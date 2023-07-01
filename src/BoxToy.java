import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Бокс с игрушками, в котором происходит розыгрыш
 */
public class BoxToy {

    private final List<Toy> toys;
    private Queue<Toy> winToys = new LinkedList<>();

    public BoxToy(List<Toy> toys) {
        this.toys = toys;
    }

    /**
     * Общий вес всех типов игрушек с учетом веса каждой отдельной игрушки и количества игрушек каждого типа
     * @return Общий вес всех игрушек
     */
    public double getChanceTotal() {
        double chance = 0;
        for (Toy toy : toys) {
            chance += toy.getChance() * toy.getCount();
        }
        return chance;
    }

    /**
     * Получение шансов выпадения игрушек каждого типа в зависимости от веса игрушки и ее количества по отношению к общему весу всех типов игрушек
     * @return Пары значений - тип игрушек: максимальное рандомное число выпадения игрушки (минимальное число - значение предыдущей пары или ноль)
     */
    public Map<Integer, Double> chancesList() {
        Map<Integer, Double> chancesList = new HashMap<>();
        double minValueChance = 0;
        for (int i = 0; i < toys.size(); i++) {
            double chance = toys.get(i).getChance() * toys.get(i).getCount() * 100 / getChanceTotal() + minValueChance;
            minValueChance += toys.get(i).getChance() * toys.get(i).getCount() * 100 / getChanceTotal();
            chancesList.put(i, (double) Math.round(chance));
        }
        return chancesList;
    }

    /**
     * Игра. Определение, какого типа игрушка выиграна в зависимости от выпавшего рандомного числа и распределения шансов выиграть игрушку
     * @param randomNumber Рандомное число для розыгрыша
     * @return Выигранную игрушку
     */
    public Toy play (int randomNumber) {
        double minChance = -1;
        int ind = 0;
        for(var item : chancesList().entrySet()) {
            if (randomNumber > minChance && randomNumber <= item.getValue() && item.getValue() > 0) {
                ind = item.getKey();
                break;
            }
            minChance = item.getValue();
        }
        System.out.println(toys.get(ind));
        return toys.get(ind);
    }

    /**
     * Добавление игрушки в список выигрышей. Уменьшение количества выигранной игрушки.
     * @param toy Игрушка
     */
    public void addWinToy (Toy toy) {
        if (toy instanceof EmptyToy) {
            System.out.println("Неудача! Ход оказался проигрышным :( Вам повезет в следующий раз.");
        } else {
            winToys.add(toy);
            System.out.printf("Было всего %d штук\n", toy.getCount());
            toy.setCount(toy.getCount() - 1);
            System.out.printf("Осталось %d штук\n", toy.getCount());
        }
    }

    /**
     * Выдача выигранных игрушек в порядке очереди. Запись выданных призов в текстовый файл.
     */
    public void giveWinToy () {
        System.out.println("------------------------");
        System.out.println("Выданы выигранные призы:");
        System.out.println("------------------------");
        while (!winToys.isEmpty()) {
            Toy toy = winToys.remove();
            System.out.println(toy);
            try (FileWriter writer = new FileWriter("wins.txt", true)) {
                writer.write(toy.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

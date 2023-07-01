import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создаем игрушки
        ConstructorToy toy1 = new ConstructorToy(0, "Знаток", 1, 10, 80);
        ConstructorToy toy2 = new ConstructorToy(1, "Лего", 2, 15, 120);
        TableGame toy3 = new TableGame(2, "Монополия", 3, 20, "L");
        TableGame toy4 = new TableGame(3, "Бродилка", 3, 25, "XL");
        PlushToy toy5 = new PlushToy(4, "Медведь", 4, 30, 30.0);
        PlushToy toy6 = new PlushToy(5, "Тигр", 2, 35, 18.0);
        EmptyToy toy7 = new EmptyToy(6, "Проигрыш", 1, 50);

        // Создаем список игрушек для розыгрыша
        List<Toy> toys = new ArrayList<>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        toys.add(toy5);
        toys.add(toy6);
        toys.add(toy7);

        // Создаем бокс с разыгрываемыми игрушками, где будут происходить все основные процессы розыгрыша
        BoxToy boxToy = new BoxToy(toys);

        // Считаем, какие шансы выпадения игрушек, в зависимости от их веса и количества
        Map<Integer, Double> chancesList = boxToy.chancesList();

        // Играем
        Random random = new Random();
        // Количество игр розыгрыша
        int countPlays = 20;
        for (int i = 0; i < countPlays; i++) {
            System.out.printf("Розыгрыш №%d\n", i);
            System.out.println("Шансы: " + chancesList);
            int rndNumber = random.nextInt(0, 100);
            System.out.println("Random = " + rndNumber);
            // Смотрим, что выпало, добавляем в список выигрышей, если игрушка; сообщение о проигрыше, если пустышка
            boxToy.addWinToy(boxToy.play(rndNumber));
            // Обновляем шансы выпадения игрушек, т.к. изменилось количество игрушек какого-то типа, если был выигрыш,
            // а также изменился совокупный вес игрушек выигранного типа в общем весе всех типов игрушек
            chancesList = boxToy.chancesList();
        }

        // Выдаем выигранные игрушки, записываем инфо в файл
        boxToy.giveWinToy();

    }

}

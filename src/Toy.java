/**
 * Игрушка, общий базовый класс
 */
public class Toy {

    protected int id;
    protected String name;
    protected int count;
    protected int chance;

    /**
     * Игрушка
     * @param id ID игрушки
     * @param name Название игрушки
     * @param count Количество игрушки
     * @param chance Вес игрушки (шанс выпадения)
     */
    public Toy(int id, String name, int count, int chance) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chance = chance;
    }

    /**
     * Получение уникального идентификатора игрушки
     * @return ID игрушки
     */
    public int getId() {
        return id;
    }

    /**
     * Получение названия игрушки
     * @return Наззвание игрушки
     */
    public String getName() {
        return name;
    }

    /**
     * Получение количества игрушки
     * @return Количество игрушки
     */
    public int getCount() {
        return count;
    }

    /**
     * Получение веса (шанса выпадения) игрушки
     * @return Вес игрушки
     */
    public int getChance() {
        return chance;
    }

    /**
     * Изменение веса (шанса выпадения) игрушки
     * @param chance Вес игрушки
     */
    public void setChance(int chance) {
        if (chance >= 0 && chance <= 100) {
            this.chance = chance;
        } else {
            System.out.println("ОШИБКА! Шанс выпадения игрушки должен составлять от 0 до 100!");
        }
    }

    /**
     * Изменение количества игрушки
     * @param count Количество игрушки
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Добавление игрушек
     * @param count Количество игрушек для добавления
     */
    public void addToy(int count) {
        if (count <= 0) {
            System.out.println("Неверное количество");
        } else {
            this.count += count;
            System.out.printf("Успешно добавлено %d игрушек (%s)! Стало %d шт.", count, name, this.count);
        }
    }

    @Override
    public String toString() {
        return String.format("Игрушка %s", name);
    }
}

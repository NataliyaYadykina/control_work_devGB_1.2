/**
 * Пустая игрушка, проигрыш
 * Если в розыгрыше предусмотрены, в том числе и проигрыши, можно добавить эту пустышку
 */
public class EmptyToy extends Toy {

    public EmptyToy(int id, String name, int count, int chance) {
        super(id, name, count, chance);
    }

    @Override
    public String toString() {
        return String.format("Проигрыш!");
    }

}

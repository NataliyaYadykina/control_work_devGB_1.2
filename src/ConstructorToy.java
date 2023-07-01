/**
 * Игрушка типа конструктор (знаток, лего и т.д.)
 */
public class ConstructorToy extends Toy {

    private int details_count;

    public ConstructorToy(int id, String name, int count, int chance, int details_count) {
        super(id, name, count, chance);
        this.details_count = details_count;
    }

    @Override
    public String toString() {
        return String.format("Игра #%d - Конструктор %s (%d деталей)", getId(), getName(), details_count);
    }
}

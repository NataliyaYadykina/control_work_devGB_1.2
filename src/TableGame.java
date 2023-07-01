/**
 * Игрушка типа настольная игра
 */
public class TableGame extends Toy {

    private String size;

    public TableGame(int id, String name, int count, int chance, String size) {
        super(id, name, count, chance);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Игра настольная #%d - %s (размер игрового поля - %s)", getId(), getName(), size);
    }
}

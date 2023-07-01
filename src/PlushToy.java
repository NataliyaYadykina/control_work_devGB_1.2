/**
 * Плюшевая игрушка
 */
public class PlushToy extends Toy {

    private double height;


    public PlushToy(int id, String name, int count, int chance, double height) {
        super(id, name, count, chance);
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Плюшевая игрушка #%d - %s (высота - %.2f см)", getId(), getName(), height);
    }
}

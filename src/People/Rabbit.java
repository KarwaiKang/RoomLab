package People;

public class Rabbit extends Enemy {
    public Rabbit(int xLoc, int yLoc) {
        super("Rabbit", xLoc, yLoc, 5, 5, 1);
    }

    @Override
    public String toString() {
        return "兎";
    }
}

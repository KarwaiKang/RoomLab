package Items;

import People.Person;
import Rooms.Room;

public class Apple extends Item implements Consumable {
    public Apple(Room room) {
        super("Apple", .1, "An apple. Heals 5 health points.", room);
    }

    public String eat(Person person) {
        int max = person.getMaxHP();
        if (person.getHP() == max)
            return "You already have full health.";
        person.setHP(person.getHP() + 5);
        if (person.getHP() > max)
            person.setHP(max);
        return "You eat the apple and gain 5 health points.";
    }
}

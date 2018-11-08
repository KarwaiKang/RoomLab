package Items;

import People.Person;

public interface Consumable {
    String type = "food";
    String eat(Person person);
}

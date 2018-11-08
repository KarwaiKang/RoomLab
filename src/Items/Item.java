package Items;

import People.Person;
import Rooms.Room;

public class Item {
    private int idx;
    private double rarity;
    private String name, description, type;
    private Room room;

    public Item(String name, double rarity, String description) {
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }

    public Item(String name, double rarity, String description, Room room) {
        this.room = room;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
        this.idx = room.addItem(this);
    }

    public Item(String name, double rarity, String description, Person person) {
        this.name = name;
        this.rarity = rarity;
        this.description = description;
        this.idx = person.addItem(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRarity() {
        return rarity;
    }

    public void setRarity(double rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String take(Person p) {
        this.room.getContents()[this.idx] = null;
        p.addItem(this);
        return "You take the " + this.name + ".";
    }

    public String eat(Person person) {
        return "You cannot eat " + this.name + ".";
    }
}

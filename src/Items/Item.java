package Items;

import Rooms.Room;

public class Item {
    private Room room;
    private String name;
    private double rarity;
    private String description;

    public Item(Room room, String name, double rarity, String description) {
        this.room = room;
        this.name = name;
        this.rarity = rarity;
        this.description = description;

        room.addItem(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

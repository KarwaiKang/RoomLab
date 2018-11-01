package Items;

import Rooms.Room;

public class Item {
    private String name;
    private double rarity;
    private Room room;
    private String description;

    public Item(String name, double rarity, Room room, String description) {
        this.name = name;
        this.rarity = rarity;
        this.room = room;
        this.description = description;

        this.room.addItem(this);
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

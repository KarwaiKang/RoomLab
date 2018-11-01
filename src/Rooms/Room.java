package Rooms;

import Items.Item;
import People.Person;

public class Room {
    Person occupant;
    private Item[] contents;
    int xLoc, yLoc;
    private String description = "You enter a plain old room";

    public Room(int xLoc, int yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }


    /**
     * Method controls the results when a person enters this room.
     *
     * @param person the Person entering
     */
    public void enterRoom(Person person) {
        System.out.println(this);
        occupant = person;
        person.setxLoc(this.xLoc);
        person.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     *
     * @param x
     */
    public void leaveRoom(Person x) {
        occupant = null;
    }

    public Item[] getContents() {
        return contents;
    }

    public void addItem(Item item) {
        Item[] newContents = new Item[this.contents.length + 1];
        for (int i = 0; i < this.contents.length; i++)
            newContents[i] = this.contents[i];
        newContents[this.contents.length + 1] = item;
        this.contents = newContents;
    }

    public String toString() {
        return description;
    }
}

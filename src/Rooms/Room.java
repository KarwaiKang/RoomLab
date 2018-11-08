package Rooms;

import Items.Item;
import People.Person;

public class Room {
    int xLoc, yLoc;
    private String description = "You enter a plain old room.";
    Person occupant;
    private Item[] contents;

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
        System.out.println(description);
        if (this.contents != null) {
            System.out.println("On the ground, you see:");
            String items = "";
            for (Item item : contents)
                items += "-" + item.getName() + " ";
            System.out.println(items);
        }
        occupant = person;
        person.setXLoc(this.xLoc);
        person.setYLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     *
     * @param person
     */
    public void leaveRoom(Person person) {
        occupant = null;
    }

    public Item[] getContents() {
        return contents;
    }

    public int addItem(Item item) {
        if (this.contents == null)
            this.contents = new Item[]{item};
        else {
            Item[] newContents = new Item[this.contents.length + 1];
            for (int i = 0; i < this.contents.length; i++)
                newContents[i] = this.contents[i];
            newContents[this.contents.length] = item;
            this.contents = newContents;
        }
        return this.contents.length - 1;
    }

    public String toString() {
        if (occupant != null)
            return "P";
        if (this.contents != null)
            return "A";
        return "_";
    }

    public String getDescription() {
        return description;
    }
}

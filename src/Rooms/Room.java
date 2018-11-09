package Rooms;

import Items.Item;
import People.Person;

public class Room {
    int xLoc, yLoc;
    private String description = "You enter a open field.";
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
    public String enterRoom(Person person) {
        String out = "";
        out += description;
        if (this.contents != null) {
            out += "\nOn the ground, you see:\n";
            String items = "";
            for (Item item : contents)
                items += "-" + item.getName() + " ";
            out += items;
        }
        if (occupant != null) {
            out += "\nYou crushed a rabbit, and take 1 damage. Ouch!\n";
            person.setHP(person.getHP() - 1);
        }
        occupant = person;
        person.setXLoc(this.xLoc);
        person.setYLoc(this.yLoc);
        return out;
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
            return occupant.toString();
        if (this.contents != null)
            return "物";
        return "　";
    }

    public String getDescription() {
        return description;
    }
}

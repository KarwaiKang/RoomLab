package People;

import Game.Board;
import Items.Item;
import Rooms.Room;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String firstName;
    String familyName;
    private int xLoc, yLoc, HP, maxHP;
    private Item[] inventory;

    public Person(String firstName, String familyName, int xLoc, int yLoc) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.HP = 5;
        this.maxHP = 100;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     *
     * @param move   the move chosen
     * @param board  the class with a 2D array of rooms
     */
    public String move(String move, Board board) {
        move = move.toLowerCase().trim();
        Room[][] map = board.rooms;
        if (move.equals("north") && xLoc > 0) {
            map[xLoc][yLoc].leaveRoom(this);
            map[xLoc - 1][yLoc].enterRoom(this);
            return "You move north.\n" + board;
        }
        if (move.equals("east") && yLoc < map[yLoc].length - 1) {
            map[xLoc][yLoc].leaveRoom(this);
            map[xLoc][yLoc + 1].enterRoom(this);
            return "You move east.\n" + board;
        }
        if (move.equals("south") && xLoc < map.length - 1) {
            map[xLoc][yLoc].leaveRoom(this);
            map[xLoc + 1][yLoc].enterRoom(this);
            return "You move south.\n" + board;
        }
        if (move.equals("west") && yLoc > 0) {
            map[xLoc][yLoc].leaveRoom(this);
            map[xLoc][yLoc - 1].enterRoom(this);
            return "You move west.\n" + board;
        }
        return "You try to move " + move + ", but you cannot.";
    }

    public int addItem(Item item) {
        if (this.inventory == null)
            this.inventory = new Item[]{item};
        else {
            Item[] newContents = new Item[this.inventory.length + 1];
            for (int i = 0; i < this.inventory.length; i++)
                newContents[i] = this.inventory[i];
            newContents[this.inventory.length] = item;
            this.inventory = newContents;
        }
        return this.inventory.length - 1;
    }
}

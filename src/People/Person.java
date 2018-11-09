package People;

import Game.Board;
import Items.Item;
import Rooms.Room;
import javafx.geometry.HPos;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String name;
    private int xLoc, yLoc, HP, maxHP;
    private Item[] inventory;

    public Person(String name, int xLoc, int yLoc, int HP, int maxHP) {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.HP = HP;
        this.maxHP = maxHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        String out = "";
        if (move.equals("north") && xLoc > 0) {
            map[xLoc][yLoc].leaveRoom(this);
            out += map[xLoc - 1][yLoc].enterRoom(this);
            return "You move north.\n" + board + out;
        }
        else if (move.equals("east") && yLoc < map[0].length - 1) {
            map[xLoc][yLoc].leaveRoom(this);
            out += map[xLoc][yLoc + 1].enterRoom(this);
            return "You move east.\n" + board + out;
        }
        else if (move.equals("south") && xLoc < map.length - 1) {
            map[xLoc][yLoc].leaveRoom(this);
            out += map[xLoc + 1][yLoc].enterRoom(this);
            return "You move south.\n" + board + out;
        }
        else if (move.equals("west") && yLoc > 0) {
            map[xLoc][yLoc].leaveRoom(this);
            out += map[xLoc][yLoc - 1].enterRoom(this);
            return "You move west.\n" + board + out;
        } else
            return "You try to move " + move + ", but realize you don't actually want to.";
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

    public String toString() {
        return "私";
    }
}

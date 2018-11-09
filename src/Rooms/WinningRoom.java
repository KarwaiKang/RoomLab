package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room {
    private String description = "You found the winning room! How much health did you get?";

    public WinningRoom(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param person the Person entering
     */
    @Override
    public String enterRoom(Person person) {
        occupant = person;
        person.setXLoc(this.xLoc);
        person.setYLoc(this.yLoc);
        System.out.println(description);
        Runner.gameOff();
        return "";
    }

    public String toString() {
        return "勝";
    }
}

package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room {
    private String description = "You found the winning room! Ten points for Gryffindor.";

    public WinningRoom(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param person the Person entering
     */
    @Override
    public void enterRoom(Person person) {
        occupant = person;
        person.setXLoc(this.xLoc);
        person.setYLoc(this.yLoc);
        System.out.println(description);
        Runner.gameOff();
    }

    public String toString() {
        return "W";
    }
}

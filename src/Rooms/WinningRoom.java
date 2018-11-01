package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room {
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
        person.setxLoc(this.xLoc);
        person.setyLoc(this.yLoc);
        System.out.println("You found the winning room! Ten points for Gryffindor.");
        Runner.gameOff();
    }
}

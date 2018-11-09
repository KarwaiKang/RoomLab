package Rooms;

import Game.Runner;
import People.Person;

public class MyRoom extends Room {
    public MyRoom(int x, int y) {
        super(x, y);
    }

    public String enterRoom(Person person) {
        occupant = person;
        person.setXLoc(this.xLoc);
        person.setYLoc(this.yLoc);
        if (person.getName().equals("Player")) {
            System.out.println("You enter your room, see your inviting bed and immediately feel compelled to lie down.\n" +
                    "Before you even realize it, you fall fast asleep.\n" +
                    "/////////////////// GAME OVER (Bad end no. 1) ///////////////////\n" +
                    "(Next time, avoid the \"負\" on the map!");
            Runner.gameOff();
        }
        return "";
    }

    public String toString() {
        return "負";
    }
}

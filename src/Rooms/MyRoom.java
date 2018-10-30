package Rooms;

import Game.Runner;
import People.Person;

public class MyRoom extends Room {
    public MyRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You enter your room, see your inviting bed and immediately feel compelled to lie down.\n" +
                "Before you even realize it, you fall fast asleep.\n" +
                "/////////////////// GAME OVER (Bad end no. 1) ///////////////////");
        Runner.gameOff();
    }
}

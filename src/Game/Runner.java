package Game;

import Items.Apple;
import People.Person;
import Rooms.MyRoom;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;

    public static void main(String[] args) {
        Board board = new Board(5,5);

        // Fill the building with normal rooms

        for (int x = 0; x < board.rooms.length; x++) {
            for (int y = 0; y < board.rooms[x].length; y++) {
                Room room = new Room(x, y);
                board.rooms[x][y] = room;
                double diffMod = (double) x / board.rooms.length;
                if (Math.random() < diffMod)
                    new Apple(room);
            }
        }

        //Create a random winning room.
        int x = (int) (Math.random() * board.rooms.length);
        int y = (int) (Math.random() * board.rooms.length);
        board.rooms[x][y] = new WinningRoom(x, y);

        //Create a random MyRoom.
        x = (int) (Math.random() * board.rooms.length);
        y = (int) (Math.random() * board.rooms.length);
        board.rooms[x][y] = new MyRoom(x, y);

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0, 0);
        Scanner in = new Scanner(System.in);
        board.rooms[0][0].enterRoom(player1);
        while (gameOn) {
            String input = in.nextLine();
            String[] inputs = input.split(" ");
            String verb = inputs[0];
            String object = inputs[1];
            switch (verb) {
                case "go":
                    validMove(object, player1, board);
                    break;
                default:
                    System.out.println("You cannot " + input + ".");
            }
        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     *
     * @param move   the move chosen
     * @param p      person moving
     * @param board  the class with a 2D array of rooms
     */
    public static void validMove(String move, Person p, Board board) {
        move = move.toLowerCase().trim();
        Room[][] map = board.rooms;
        int x = p.getXLoc();
        int y = p.getYLoc();
        if (move.equals("north") && x > 0) {
            map[x][y].leaveRoom(p);
            map[x - 1][y].enterRoom(p);
            System.out.println(board);
        } else if (move.equals("east") && y < map[y].length - 1) {
            map[x][y].leaveRoom(p);
            map[x][y + 1].enterRoom(p);
            System.out.println(board);
        } else if (move.equals("south") && x < map.length - 1) {
            map[x][y].leaveRoom(p);
            map[x + 1][y].enterRoom(p);
            System.out.println(board);
        } else if (move.equals("west") && y > 0) {
            map[x][y].leaveRoom(p);
            map[x][y - 1].enterRoom(p);
            System.out.println(board);
        } else {
            System.out.println("You try to move " + move + ", but there is a wall there.");
        }
    }

    public static void gameOff() {
        gameOn = false;
    }


}

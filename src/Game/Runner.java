package Game;

import Items.Apple;
import Items.Item;
import People.Person;
import Rooms.MyRoom;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;
    private static Board board = new Board(5,100);
    private static Person player1 = new Person("FirstName", "FamilyName", 0, 0);
    private static String help = "List of available commands:\n" +
            "\"help\" to see this message again.\n" +
            "\"go <north|south|east|west>\" to move.\n" +
            "\"check <map|health>\" to look at the map/your health.\n" +
            "\"examine <item>\" to examine items in your inventory.\n" +
            "\"take <item>\" to put items that are in the room in your inventory.\n" +
            "\"eat <food>\" to eat food items.";

    public static void main(String[] args) {
        // Fill the building with normal rooms

        for (int x = 0; x < board.rooms.length; x++) {
            for (int y = 0; y < board.rooms[x].length; y++) {
                Room room = new Room(x, y);
                board.rooms[x][y] = room;
                double diffMod = (double) y / board.rooms[0].length;
                if (Math.random() < diffMod)
                    new Apple(room);
            }
        }

        //Create a random winning room.
        int x = (int) (Math.random() * board.rooms.length);
        int y = board.rooms[0].length - 1;
        board.rooms[x][y] = new WinningRoom(x, y);

        //Create a random MyRoom.
        x = (int) (Math.random() * board.rooms.length);
        y = (int) (Math.random() * board.rooms.length);
        board.rooms[x][y] = new MyRoom(x, y);

        Scanner in = new Scanner(System.in);
        System.out.println(help);
        board.rooms[0][0].enterRoom(player1);
        while (gameOn) {
            String input = in.nextLine();
            String[] inputs = input.split(" ");
            String verb = inputs[0];
            String object = inputs[1];
            switch (verb) {
                case "help":
                    System.out.println(help);
                    break;
                case "go":
                    System.out.println(player1.move(object, board));
                    break;
                case "check":
                    switch (object) {
                        case "map":
                            System.out.println(board);
                            break;
                        case "health":
                            System.out.println(player1.getHP() + "/" + player1.getMaxHP());
                            break;
                    }
                    break;
                case "examine":
                    Item i = findItem(object, player1.getInventory());
                    if (i == null)
                        System.out.println("You don't have a " + object + ".");
                    else
                        System.out.println(i.getDescription());
                    break;
                case "take":
                    Item item = findItem(object, board.rooms[player1.getXLoc()][player1.getYLoc()].getContents());
                    if (item == null)
                        System.out.println("There is no " + object + " here.");
                    else
                        System.out.println(item.take(player1));
                    break;
                case "eat":
                    Item food = findItem(object, player1.getInventory());
                    if (food == null)
                        System.out.println("You don't have a " + object + ".");
                    else
                        System.out.println(food.eat(player1));
                    break;
                default:
                    System.out.println("You cannot " + input + ". (type \"help\" for more options.)");
            }
        }
        in.close();
    }

    private static Item findItem(String item, Item[] itemArr) {
        for (Item i : itemArr) {
            if (i.getName().toLowerCase().equals(item.toLowerCase()))
                return i;
        }
        return null;
    }

    public static void gameOff() {
        gameOn = false;
    }
}

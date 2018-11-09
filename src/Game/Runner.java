package Game;

import Items.Apple;
import Items.Item;
import People.Enemy;
import People.Person;
import People.Rabbit;
import Rooms.MyRoom;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;
    private static Board board = new Board(5,100);
    private static Person player1 = new Person("Player", 0, 0, 10, 10);
    private static String help = "List of available commands:\n" +
            "\"help\" to see this message again.\n" +
            "\"go <north|south|east|west>\" to move.\n" +
            "\"check <map|health|inventory>\" to look at the map/your health.\n" +
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
                if (diffMod > .25)
                    diffMod = .25;
                if (Math.random() < diffMod)
                    new Apple(room);
                else if (Math.random() < .15)
                    room.enterRoom(new Rabbit(x, y));
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
        System.out.println("\n" + board.rooms[0][0].enterRoom(player1));
        System.out.println("There are rabbits (兎) and apples (物) nearby. You feel compelled to crush the rabbits, and eat the apples.");
        while (gameOn) {
            String input = in.nextLine().trim();
            String verb, object;
            if (input.contains(" ")) {
                String[] inputs = input.split(" ");
                verb = inputs[0];
                object = inputs[1];
            }
            else {
                verb = input;
                object = "";
            }
            switch (verb) {
                case "help":
                    System.out.println(help);
                    break;
                case "go":
                    System.out.println(player1.move(object, board));
                    for (Enemy enemy : Enemy.enemies) {
                        String move = new String[]{"north", "south", "west", "east"}[(int) Math.floor(Math.random() * 3)];
                        enemy.move(move, board);
                    }
                    break;
                case "check":
                    switch (object) {
                        case "map":
                            System.out.println(board);
                            break;
                        case "health":
                            System.out.println(player1.getHP() + "/" + player1.getMaxHP());
                            break;
                        case "inventory":
                            String out = "";
                            if (player1.getInventory() == null)
                                System.out.println("Your don't have anything. (type \"help\" for more options.)");
                            else {
                                for (Item item : player1.getInventory())
                                    out += " -" + item.getName();
                            }
                            break;
                        default:
                            System.out.println("You can't check " + object + ". (type \"help\" for more options.)");
                    }
                    break;
                case "examine":
                    if (object.equals("room")) {
                        System.out.println(board.rooms[player1.getXLoc()][player1.getYLoc()].getDescription());
                        break;
                    }
                    Item i = findItem(object, player1.getInventory());
                    if (i == null)
                        System.out.println("You don't have a " + object + ". (type \"help\" for more options.)");
                    else
                        System.out.println(i.getDescription());
                    break;
                case "take":
                    Item item = findItem(object, board.rooms[player1.getXLoc()][player1.getYLoc()].getContents());
                    if (item == null)
                        System.out.println("There is no " + object + " here. (type \"help\" for more options.)");
                    else
                        System.out.println(item.take(player1));
                    break;
                case "eat":
                    Item food = findItem(object, player1.getInventory());
                    if (food == null)
                        System.out.println("You don't have a " + object + ". (type \"help\" for more options.)");
                    else
                        System.out.println(food.eat(player1));
                    break;
                default:
                    System.out.println("You cannot " + input + ". (type \"help\" for more options.)");
                if (player1.getHP() <= 0) {
                    System.out.println("Oh no! You have died from stepping on too many rabbits.");
                    gameOff();
                }
            }
        }
        in.close();
    }

    private static Item findItem(String item, Item[] itemArr) {
        if (itemArr == null)
            return null;
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

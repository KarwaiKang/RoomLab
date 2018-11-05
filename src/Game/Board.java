package Game;

import Rooms.Room;

public class Board {
    public Room[][] rooms;

    public Board(Room[][] rooms) {
        this.rooms = rooms;
    }

    public Board(int l, int w) {
        this.rooms = new Room[l][w];
    }

    public String toString() {
        String out = "";
        for (Room[] row : this.rooms) {
            for (Room room : row)
                out += room.toString();
            out += "\n";
        }
        return out;
    }
}
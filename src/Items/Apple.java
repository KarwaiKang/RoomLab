package Items;

import Rooms.Room;

public class Apple extends Item {
    public Apple(Room room) {
        super("Apple", .1, "An apple.", room);
    }
}

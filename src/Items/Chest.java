package Items;

import Rooms.Room;

public class Chest extends Item {
    private Item[] contents;
    private boolean locked;

    public Chest(String name, double rarity, Room room, String description, Item[] contents, boolean locked) {
        super(name, rarity, description, room);
        this.contents = contents;
        this.locked = locked;
    }

    public Item[] getContents() {
        return contents;
    }

    public void setContents(Item[] contents) {
        this.contents = contents;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

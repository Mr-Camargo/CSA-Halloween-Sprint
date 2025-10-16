import java.util.ArrayList;

/**
 * Room class represents a location in the haunted house.
 * Each room has a name, description, items, and exits to other rooms.
 */
class Room {
    // Properties as specified in README.md
    String name;
    String description;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Room> exits = new ArrayList<>();
    
    /**
     * Constructor to create a room with a name and description.
     * @param name The name of the room
     * @param description The description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Adds an exit (connected room) to this room.
     * @param room The room to connect as an exit
     */
    public void addExit(Room room) {
        exits.add(room);
    }
    
    /**
     * Adds an item to this room.
     * @param item The item to add to the room
     */
    public void addItem(Item item) {
        items.add(item);
    }
    
    /**
     * Displays information about the room when entering.
     * Shows the room name, description, items present, and available exits.
     */
    public void enterRoom() {
        System.out.println("You are in " + name);
        System.out.println(description);
        
        // Display items in the room
        System.out.print("Items in the room: ");
        if (items.isEmpty()) {
            System.out.println("None");
        } else {
            ArrayList<String> itemNames = new ArrayList<>();
            for (Item item : items) {
                itemNames.add(item.name);
            }
            System.out.println(String.join(", ", itemNames));
        }
        
        // Display exits
        System.out.print("Exits: ");
        if (exits.isEmpty()) {
            System.out.println("None");
        } else {
            ArrayList<String> exitNames = new ArrayList<>();
            for (Room exit : exits) {
                exitNames.add(exit.name);
            }
            System.out.println(String.join(", ", exitNames));
        }
    }
    
    /**
     * Removes an item from the room (useful when player picks up an item).
     * @param item The item to remove
     * @return true if the item was found and removed, false otherwise
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }
    
    /**
     * Gets an item by name from the room.
     * @param itemName The name of the item to find
     * @return The item if found, null otherwise
     */
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Gets an exit room by name.
     * @param roomName The name of the room to find
     * @return The room if found, null otherwise
     */
    public Room getExit(String roomName) {
        for (Room room : exits) {
            if (room.name.equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }
}
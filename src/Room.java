import java.util.ArrayList;

/**
 * Room class represents a location in the haunted house.
 * Each room has a name, description, items, exits to other rooms, and may contain monsters.
 */
class Room {
    // Properties as specified in README.md
    String name;
    String description;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Room> exits = new ArrayList<>();
    ArrayList<Monster> monsters = new ArrayList<>(); // Monsters in this room
    
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
     * Adds a monster to this room.
     * @param monster The monster to add to the room
     */
    public void addMonster(Monster monster) {
        monsters.add(monster);
    }
    
    /**
     * Displays information about the room when entering.
     * Shows the room name, description, items present, monsters present, and available exits.
     */
    public void enterRoom() {
        System.out.println("\n========================================");
        System.out.println("You are in " + name);
        System.out.println(description);
        System.out.println("========================================");
        
        // Display monsters in the room
        if (!monsters.isEmpty()) {
            System.out.println("\n⚠️ MONSTERS PRESENT:");
            for (Monster monster : monsters) {
                if (monster.isAlive()) {
                    System.out.println("  - " + monster.name + " (Health: " + monster.health + ")");
                }
            }
        }
        
        // Display items in the room
        System.out.print("\n📦 Items in the room: ");
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
        System.out.print("\n🚪 Exits: ");
        if (exits.isEmpty()) {
            System.out.println("None");
        } else {
            ArrayList<String> exitNames = new ArrayList<>();
            for (Room exit : exits) {
                exitNames.add(exit.name);
            }
            System.out.println(String.join(", ", exitNames));
        }
        System.out.println("========================================\n");
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
    
    /**
     * Gets all living monsters in this room.
     * @return ArrayList of living monsters
     */
    public ArrayList<Monster> getLivingMonsters() {
        ArrayList<Monster> living = new ArrayList<>();
        for (Monster monster : monsters) {
            if (monster.isAlive()) {
                living.add(monster);
            }
        }
        return living;
    }
    
    /**
     * Checks if there are any living monsters in the room.
     * @return true if there are living monsters, false otherwise
     */
    public boolean hasLivingMonsters() {
        for (Monster monster : monsters) {
            if (monster.isAlive()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes a dead monster from the room.
     * @param monster The monster to remove
     */
    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }
}
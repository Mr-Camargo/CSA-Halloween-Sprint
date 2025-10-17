import java.util.ArrayList;

class Player {
    int health = 100;
    int strength = 10; // Base attack damage
    ArrayList<Item> inventory = new ArrayList<>();
    Room currentRoom;

    // Show player's inventory
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You have the following items:");
            for (Item item : inventory) {
                System.out.println("- " + item.name + ": " + item.description);
            }
        }
    }

    // Pick up an item and add to inventory
    public void pickUpItem(Item item) {
        inventory.add(item);
        System.out.println("You picked up: " + item.name);
    }

    // Move player to a new room
    public void move(Room nextRoom) {
        currentRoom = nextRoom;
        currentRoom.enterRoom();
    }

    // Use an item from inventory
    public void useItem(String itemName, Monster monster) {
        for (Item item : inventory) {
            if (item.name.equalsIgnoreCase(itemName)) {
                item.use(this, monster);
                inventory.remove(item);
                return;
            }
        }
        System.out.println("You don't have that item.");
    }
    
    /**
     * Attack a monster with the player's current strength.
     * @param monster The monster to attack
     */
    public void attackMonster(Monster monster) {
        if (monster != null && monster.isAlive()) {
            System.out.println("\nYou attack the " + monster.name + "!");
            monster.takeDamage(this.strength);
            
            if (!monster.isAlive()) {
                System.out.println("💀 You defeated the " + monster.name + "!");
            }
        } else {
            System.out.println("There's nothing to attack!");
        }
    }
    
    /**
     * Check if the player is still alive.
     * @return true if health > 0, false otherwise
     */
    public boolean isAlive() {
        return this.health > 0;
    }
    
    /**
     * Display player's current status.
     */
    public void showStatus() {
        System.out.println("\n=== PLAYER STATUS ===");
        System.out.println("❤️  Health: " + health + "/100");
        System.out.println("⚔️  Strength: " + strength);
        System.out.println("📍 Location: " + (currentRoom != null ? currentRoom.name : "Unknown"));
        System.out.println("====================\n");
    }
}

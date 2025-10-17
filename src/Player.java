import java.util.ArrayList;

class Player {
    int health = 100;
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
}

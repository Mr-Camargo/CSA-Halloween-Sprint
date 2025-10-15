class Room {
    String name;
    String description;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Room> exits = new ArrayList<>();
    
    public void addExit(Room room) {
        exits.add(room);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void enterRoom() {
        System.out.println("You are in " + name);
        System.out.println(description);
        System.out.println("Items in the room: " + items);
        System.out.println("Exits: " + exits);
    }
}

class Item {
    String name;
    String description;
    String effect;

    public void use(Player player, Monster monster) {
        // Define what the item does
        if (effect.equals("heal")) {
            player.health += 15; // health effect
            }
            else {
                system.out.println("item has no effect");
            }
            if (player.health > 100) {
                player.health = 100; // cap health at 100 then stop allowing player to keep healing
            }
            if (player.health >= 86) {
                system.out.println("healing wont be as effective"); // warn player about effectiveness of healing at high health
            }
        }
    }

class Monster {
    String name;
    int strength;
    int health;
    String description;

    public void attack(Player player) {
        // Reduce player’s health based on monster’s strength
    }
}

class Player {
    int health = 100;
    ArrayList<Item> inventory = new ArrayList<>();
    Room currentRoom;

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void move(Room nextRoom) {
        currentRoom = nextRoom;
        currentRoom.enterRoom();
    }
}
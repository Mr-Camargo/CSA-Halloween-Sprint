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
class skeleton extends Monster {
    public skeleton() {
        this.name = "Skeleton";
        this.strength = 5;
        this.health = 40;
        this.description = "A spooky skeleton warrior.";
    }
    @Override 
    public void attack(Player player) {
        player.health -= this.strength;
        System.out.println(this.name + " attacks! Player health is now: " + player.health);
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
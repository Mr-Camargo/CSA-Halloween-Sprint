// encapsulate onto main class
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Initialize game elements here
    /*     Player player = new Player();
        Room startRoom = new Room();
        startRoom.name = "Haunted Hallway";
        startRoom.description = "A dark, eerie hallway with flickering lights.";

        Item flashlight = new Item();
        flashlight.name = "Flashlight";
        flashlight.description = "A handy flashlight to light your way.";
        flashlight.effect = "Illuminates dark areas.";

        startRoom.addItem(flashlight);

        player.currentRoom = startRoom;
        player.currentRoom.enterRoom(); */

    // Game loop and logic would go here

    Strings strings = new Strings();

    class Room {
      public void addExit(Room room) {
        exits.add(room);
      }

      public void addItem(Item item) {
        items.add(item);
      }

      public void enterRoom() {
        room = new Rooms();

        room.enterRoom();

        // Check if the room is dark and if the player has a flashlight
        if (room.description.contains("dark")
            && player.inventory.contains(flashlight)) {
          String illuminatedDescription =
              room.respondAction("flashlightOnDarkRoom");
          System.out.println(illuminatedDescription);
        }

        System.out.println("You are in " + room.name);
        System.out.println(room.description);
        System.out.println("Items in the room: " + room.items("getItems"));
        System.out.println("Exits: " + room.exits("getExits"));
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
      String description;
class Monster {
    String name;
    int strength;
    int health;
    String description;

      public void attack(Player player) {
        // Reduce player’s health based on monster’s strength
      }
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
        System.out.println(this.name + " uses his spine and whips you! Your health is now: " + player.health);
    }
    class zombie extends Monster {
    public zombie() {
        this.name = "Zombie";
        this.strength = 10;
        this.health = 100;
        this.description = "A slow and week but relentless zombie.";
    }
    @Override 
    public void attack(Player player) {
        player.health -= this.strength;
        System.out.println(this.name + " bites and thrashes at you! Your health is now: " + player.health);
    }  
    class slime extends Monster {
    public slime() {
        this.name = "Slime";
        this.strength = 5;
        this.health = 30;
        this.description = "A small, gelatinous blob.";
    }
    @Override 
    public void attack(Player player) {
        attackCount++;
        int rampedStrength = this.strength * attackCount;
        System.out.println("The slime spits acid at you! The slime's acid burns stronger with each attack!" + (player.health -= rampedStrength));
System.out.println(this.name + " spits acid at you! Your health is now: " + player.health);
player.health = player.health - (rampedStrength + this.strength);
        System.out.println(this.name + " spits acid at you! Your health is now: " + player.health);
    }
    }
}
}
class Vampire extends Monster {
    Random rand = new Random();
    public Vampire() {
        this.name = "Vampire";
        this.strength = 40;
        this.health = 120;
        this.description = "A fast and deadly vampire.";
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
  }

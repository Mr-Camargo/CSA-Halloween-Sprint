import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main game class - Halloween Haunted House Adventure
 * Implements the core game logic as specified in README.md
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player;
    private static boolean gameRunning = true;

    public static void main(String[] args) {
        // Display welcome message
        displayWelcome();
        
        // Initialize the game world
        player = new Player();
        Room[] rooms = createHauntedHouse();
        player.currentRoom = rooms[0]; // Start in entrance hall
        
        // Main game loop
        while (gameRunning && player.isAlive()) {
            player.currentRoom.enterRoom();
            
            // Check win condition
            if (player.currentRoom.name.equals("Exit Door")) {
                displayVictory();
                break;
            }
            
            // Check for monsters in room
            if (player.currentRoom.hasLivingMonsters()) {
                handleCombat();
                if (!player.isAlive()) {
                    displayGameOver();
                    break;
                }
            }
            
            // Player action menu
            displayActionMenu();
            handlePlayerAction();
        }
        
        scanner.close();
    }
    
    /**
     * Display welcome message and game introduction
     */
    private static void displayWelcome() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎃 HAUNTED HOUSE ADVENTURE - HALLOWEEN EDITION 👻");
        System.out.println("=".repeat(60));
        System.out.println("\nYou find yourself trapped in a haunted mansion on Halloween night.");
        System.out.println("Navigate through the spooky rooms, defeat monsters, and find the exit!");
        System.out.println("Collect items to help you survive the horrors that await...\n");
        System.out.println("=".repeat(60) + "\n");
        System.out.print("Press ENTER to begin your adventure...");
        scanner.nextLine();
        System.out.println();
    }
    
    /**
     * Create the haunted house with rooms, items, and monsters
     * @return Array of connected rooms
     */
    private static Room[] createHauntedHouse() {
        // Create rooms
        Room entranceHall = new Room("Entrance Hall", 
            "A grand entrance with cobwebs and dusty portraits on the walls.");
        
        Room library = new Room("Dark Library", 
            "Rows of ancient books line the walls. Something moves in the shadows...");
        
        Room kitchen = new Room("Abandoned Kitchen", 
            "Old pots and pans hang from the ceiling. The smell of decay fills the air.");
        
        Room basement = new Room("Creepy Basement", 
            "Stone walls drip with moisture. You hear strange sounds echoing...");
        
        Room bedroom = new Room("Haunted Bedroom", 
            "A dusty four-poster bed sits in the center. Cold air chills your bones.");
        
        Room attic = new Room("Dusty Attic", 
            "Broken furniture and old trunks scatter the floor. Bats fly overhead!");
        
        Room exit = new Room("Exit Door", 
            "You found the exit! Freedom awaits!");
        
        // Connect rooms (create the maze)
        entranceHall.addExit(library);
        entranceHall.addExit(kitchen);
        
        library.addExit(entranceHall);
        library.addExit(bedroom);
        
        kitchen.addExit(entranceHall);
        kitchen.addExit(basement);
        
        basement.addExit(kitchen);
        basement.addExit(attic);
        
        bedroom.addExit(library);
        bedroom.addExit(attic);
        
        attic.addExit(bedroom);
        attic.addExit(basement);
        attic.addExit(exit);
        
        exit.addExit(attic);
        
        // Add items to rooms
        entranceHall.addItem(new Item("Health Potion", 
            "A glowing red potion that restores health", "heal"));
        entranceHall.addItem(new Item("Rusty Sword", 
            "An old sword that increases your strength", "strength"));
        
        library.addItem(new Item("Ancient Scroll", 
            "A magical scroll that damages monsters", "damage"));
        
        kitchen.addItem(new Item("Health Potion", 
            "A glowing red potion that restores health", "heal"));
        
        basement.addItem(new Item("Poison Vial", 
            "A dangerous poison that severely damages monsters", "poison"));
        
        bedroom.addItem(new Item("Magic Amulet", 
            "A mystical amulet that boosts your power", "strength"));
        
        attic.addItem(new Item("Health Potion", 
            "A glowing red potion that restores health", "heal"));
        attic.addItem(new Item("Holy Water", 
            "Blessed water that damages undead creatures", "damage"));
        
        // Add monsters to rooms
        library.addMonster(new Skeleton());
        
        kitchen.addMonster(new Zombie());
        
        basement.addMonster(new Slime());
        basement.addMonster(new Skeleton());
        
        bedroom.addMonster(new Ghost());
        
        attic.addMonster(new Vampire());
        
        return new Room[] {entranceHall, library, kitchen, basement, bedroom, attic, exit};
    }
    
    /**
     * Handle combat encounters with monsters
     */
    private static void handleCombat() {
        ArrayList<Monster> monsters = player.currentRoom.getLivingMonsters();
        
        if (monsters.isEmpty()) {
            return;
        }
        
        System.out.println("\n⚔️  COMBAT INITIATED! ⚔️\n");
        
        while (player.isAlive() && player.currentRoom.hasLivingMonsters()) {
            // Show combat status
            System.out.println("\n--- COMBAT STATUS ---");
            System.out.println("Your Health: " + player.health + " HP");
            System.out.println("Your Strength: " + player.strength);
            System.out.println("\nEnemies:");
            
            monsters = player.currentRoom.getLivingMonsters();
            for (int i = 0; i < monsters.size(); i++) {
                Monster m = monsters.get(i);
                System.out.println("  " + (i + 1) + ". " + m.name + " (HP: " + m.health + ")");
            }
            
            // Combat menu
            System.out.println("\n--- COMBAT ACTIONS ---");
            System.out.println("1. Attack a monster");
            System.out.println("2. Use an item");
            System.out.println("3. Try to flee");
            System.out.print("\nChoose your action: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    handleAttack(monsters);
                    break;
                case "2":
                    handleItemUse(monsters);
                    break;
                case "3":
                    if (attemptFlee()) {
                        return; // Successfully fled
                    }
                    break;
                default:
                    System.out.println("❌ Invalid action!");
                    continue;
            }
            
            // Monsters attack back if still alive
            if (player.currentRoom.hasLivingMonsters()) {
                System.out.println("\n🔴 Monsters attack!");
                monsters = player.currentRoom.getLivingMonsters();
                for (Monster monster : monsters) {
                    if (monster.isAlive()) {
                        monster.attack(player);
                    }
                }
                
                if (!player.isAlive()) {
                    return;
                }
            } else {
                System.out.println("\n✅ All monsters defeated! The room is safe.");
                break;
            }
        }
    }
    
    /**
     * Handle player attacking a monster
     */
    private static void handleAttack(ArrayList<Monster> monsters) {
        if (monsters.size() == 1) {
            player.attackMonster(monsters.get(0));
            if (!monsters.get(0).isAlive()) {
                player.currentRoom.removeMonster(monsters.get(0));
            }
        } else {
            System.out.print("Which monster to attack? (1-" + monsters.size() + "): ");
            try {
                int target = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (target >= 0 && target < monsters.size()) {
                    Monster targetMonster = monsters.get(target);
                    player.attackMonster(targetMonster);
                    if (!targetMonster.isAlive()) {
                        player.currentRoom.removeMonster(targetMonster);
                    }
                } else {
                    System.out.println("❌ Invalid target!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input!");
            }
        }
    }
    
    /**
     * Handle using items in combat
     */
    private static void handleItemUse(ArrayList<Monster> monsters) {
        if (player.inventory.isEmpty()) {
            System.out.println("You have no items to use!");
            return;
        }
        
        player.showInventory();
        System.out.print("Enter item name to use (or 'cancel'): ");
        String itemName = scanner.nextLine().trim();
        
        if (itemName.equalsIgnoreCase("cancel")) {
            return;
        }
        
        // Determine target for offensive items
        Monster target = null;
        for (Item item : player.inventory) {
            if (item.name.equalsIgnoreCase(itemName)) {
                if (item.effect.equals("damage") || item.effect.equals("poison")) {
                    if (monsters.size() == 1) {
                        target = monsters.get(0);
                    } else {
                        System.out.print("Which monster to target? (1-" + monsters.size() + "): ");
                        try {
                            int targetIdx = Integer.parseInt(scanner.nextLine().trim()) - 1;
                            if (targetIdx >= 0 && targetIdx < monsters.size()) {
                                target = monsters.get(targetIdx);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Invalid target!");
                            return;
                        }
                    }
                }
                break;
            }
        }
        
        player.useItem(itemName, target);
        
        // Remove dead monsters
        for (int i = monsters.size() - 1; i >= 0; i--) {
            if (!monsters.get(i).isAlive()) {
                player.currentRoom.removeMonster(monsters.get(i));
            }
        }
    }
    
    /**
     * Attempt to flee from combat
     */
    private static boolean attemptFlee() {
        ArrayList<Room> exits = player.currentRoom.exits;
        if (exits.isEmpty()) {
            System.out.println("❌ There's nowhere to run!");
            return false;
        }
        
        System.out.println("🏃 You flee to a random exit!");
        Room randomExit = exits.get((int)(Math.random() * exits.size()));
        player.currentRoom = randomExit;
        System.out.println("You escaped to: " + randomExit.name);
        return true;
    }
    
    /**
     * Display the main action menu
     */
    private static void displayActionMenu() {
        System.out.println("\n--- WHAT DO YOU WANT TO DO? ---");
        System.out.println("1. Move to another room");
        System.out.println("2. Pick up an item");
        System.out.println("3. View inventory");
        System.out.println("4. View status");
        System.out.println("5. Look around (re-examine room)");
        System.out.println("6. Quit game");
        System.out.print("\nEnter your choice: ");
    }
    
    /**
     * Handle player's action choice
     */
    private static void handlePlayerAction() {
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                handleMove();
                break;
            case "2":
                handlePickUpItem();
                break;
            case "3":
                player.showInventory();
                System.out.print("\nPress ENTER to continue...");
                scanner.nextLine();
                break;
            case "4":
                player.showStatus();
                System.out.print("\nPress ENTER to continue...");
                scanner.nextLine();
                break;
            case "5":
                // Room will be displayed at start of next loop
                break;
            case "6":
                System.out.println("\n👻 Thanks for playing! Goodbye!");
                gameRunning = false;
                break;
            default:
                System.out.println("❌ Invalid choice! Try again.");
        }
    }
    
    /**
     * Handle player movement between rooms
     */
    private static void handleMove() {
        ArrayList<Room> exits = player.currentRoom.exits;
        
        if (exits.isEmpty()) {
            System.out.println("There are no exits from this room!");
            return;
        }
        
        System.out.println("\nAvailable exits:");
        for (int i = 0; i < exits.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + exits.get(i).name);
        }
        
        System.out.print("\nChoose a room (1-" + exits.size() + ") or 0 to cancel: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                return;
            }
            if (choice > 0 && choice <= exits.size()) {
                Room nextRoom = exits.get(choice - 1);
                System.out.println("\n🚪 Moving to " + nextRoom.name + "...\n");
                player.move(nextRoom);
            } else {
                System.out.println("❌ Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input!");
        }
    }
    
    /**
     * Handle picking up items from the room
     */
    private static void handlePickUpItem() {
        ArrayList<Item> items = player.currentRoom.items;
        
        if (items.isEmpty()) {
            System.out.println("There are no items in this room.");
            return;
        }
        
        System.out.println("\nItems available:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + items.get(i).name + " - " + items.get(i).description);
        }
        
        System.out.print("\nChoose an item (1-" + items.size() + ") or 0 to cancel: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                return;
            }
            if (choice > 0 && choice <= items.size()) {
                Item item = items.get(choice - 1);
                player.pickUpItem(item);
                player.currentRoom.removeItem(item);
            } else {
                System.out.println("❌ Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input!");
        }
    }
    
    /**
     * Display victory message
     */
    private static void displayVictory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎉 CONGRATULATIONS! YOU ESCAPED THE HAUNTED HOUSE! 🎉");
        System.out.println("=".repeat(60));
        System.out.println("\nYou defeated the monsters and found your way out!");
        System.out.println("Final Health: " + player.health + " HP");
        System.out.println("Final Strength: " + player.strength);
        System.out.println("\nThanks for playing! Happy Halloween! 🎃👻");
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Display game over message
     */
    private static void displayGameOver() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("💀 GAME OVER - YOU HAVE PERISHED 💀");
        System.out.println("=".repeat(60));
        System.out.println("\nThe monsters were too powerful...");
        System.out.println("Better luck next time!");
        System.out.println("\n👻 Happy Halloween! 🎃");
        System.out.println("=".repeat(60) + "\n");
    }
}
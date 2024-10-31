
# 🎃 Haunted House Adventure Game - CS++ Halloween Code Sprint 👻

Welcome to the **Haunted House Adventure Game**! In this 90-minute code sprint, you and your team will build a spooky, text-based adventure game where players explore a haunted house, encountering monsters and picking up mysterious items along the way. Your goal is to create a playable game with clear, object-oriented code using arrays and ArrayLists.

---

## 🕸️ Project Overview

In this game, players will navigate through rooms in a haunted house filled with monsters, items, and clues to help them escape. By designing classes, using arrays or ArrayLists, and coding game logic, you'll create a Halloween-themed game that brings together your programming skills and creativity!

### Objective
- **Design** and **implement** classes (`Room`, `Monster`, `Item`, and `Player`).
- **Use arrays/ArrayLists** to store and manage game elements.
- Complete the game within **90 minutes**!

---

## 👥 Teams and Sprint Structure

- **Team Size**: 3-4 members
- **Time Limit**: 90 minutes
- **Roles**: Assign each team member a class or feature to work on (e.g., `Room`, `Monster`, `Item`, `Player`, or Game Logic).

## 📜 Instructions

### 1. **Game Premise**
   - Players are trapped in a haunted house and must navigate spooky rooms to reach the exit.
   - Each room may contain monsters and items that players can interact with.
   - Use object-oriented principles, arrays, and ArrayLists to build the haunted house.

### 2. **Design the Classes**

   - **Room Class**
     - Properties: `name`, `description`, `items` (ArrayList<Item>), `exits` (ArrayList<Room>)
     - Methods: `addExit(Room room)`, `addItem(Item item)`, `enterRoom()`

   - **Monster Class**
     - Properties: `name`, `strength`, `description`
     - Methods: `describe()`, `attack(Player player)`

   - **Item Class**
     - Properties: `name`, `description`, `effect`
     - Methods: `use(Player player, Monster monster)`

   - **Player Class**
     - Properties: `health`, `inventory` (ArrayList<Item>), `currentRoom`
     - Methods: `pickUpItem(Item item)`, `move(Room nextRoom)`, `useItem(Item item, Monster monster)`

### 3. **Use Arrays and ArrayLists**

   - **Room Exits**: Store connected rooms in the `exits` ArrayList in each `Room` object.
   - **Room Items**: Use an ArrayList to hold `Item` objects in each room.
   - **Player Inventory**: Track the player’s items in an ArrayList in the `Player` class.

### 4. **Gameplay Mechanics**

   - **Moving Between Rooms**:  
     Players can view exits in the room and choose a direction to move to the next room.

   - **Item Interactions**:  
     Players can pick up items to add to their inventory, which can be used to handle challenges.

   - **Monster Encounters**:  
     Players can fight or use items to weaken or escape monsters.

   - **End Goal**:  
     The player’s objective is to navigate the rooms and reach the exit.

### 5. **Class Structure Example**

Use the following skeleton code as a starting point:

```java
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
```

---

## 🧪 Testing and Final Playthrough

- **Test each part**: Test features like room navigation, item pickup, and monster encounters.
- **Final Playthrough**: Run a complete playthrough with your team to test the game flow and make final adjustments.

---

## 🎉 Wrap-Up

At the end of the sprint, each team will present their game. Show off the haunted house, key encounters, and anything unique your team added to make the game spooky or fun.

Enjoy coding, and happy Halloween!

---

**Authors**: CS++ 
**Date**: October 31, 2024  

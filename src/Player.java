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
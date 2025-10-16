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
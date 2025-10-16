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
}}
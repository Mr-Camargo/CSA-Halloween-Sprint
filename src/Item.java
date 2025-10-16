    class Item {

      String name;
      String description;
      String effect;

      public void use(Player player, Monster monster) {
        // apply heal effect on player, variables for healing will be set later in this file
        if (effect.equals("heal")) {
            player.health += 15; // health effect
            }
            else {
                System.out.println("item has no effect");
            }
            if (player.health > 100) {
                player.health = 100; // cap health at 100 then stop allowing player to keep healing
            }
            if (player.health >= 86) {
                System.out.println("healing wont be as effective"); // warn player about effectiveness of healing at high health
            }
        }
      }
         
      if (effect.equals("strength")) {
            player.strength += 10; // added strength variable, 10 base + 10 from item = 20 strength total\
            System.out.println("Strength increased by 10, damage is now 20");
            true = false; { // rids the possibility of infinite strength stacking (foolproof)
            true until 
      }
    }


class Item {

    String name;
    String description;
    String effect; // "heal" or "strength"
    int power;     // amount of heal or strength change
    int duration;  // number of turns the effect lasts

    // Track active temporary effects per Player
    private static final java.util.IdentityHashMap<Player, java.util.List<StatusEffect>> activeEffects =
            new java.util.IdentityHashMap<>();

    public Item(String name, String description, String effect, int power, int duration) {
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.power = power;
        this.duration = duration;
    }

    // Use the item on player.
    // once per game turn to decrement durations and automatically revert expired effects.
    public void use(Player player, Monster monster) {
        if (effect == null) {
            System.out.println("This item does nothing.");
            return;
        }

        switch (effect) {
            case "heal":
                player.health += power;
                if (player.health > 100) {
                    player.health = 100; // Health cap
                }
                if (player.health >= 86) {
                    System.out.println("Healing won't be as effective at high health.");
                }
                System.out.println(name + " used: healed " + power + " HP. Current health: " + player.health);
                break;

            case "strength":
                // Apply immediate strength buff and register a temporary effect to revert later
                player.strength += power;
                addStatusEffect(player, new StatusEffect("strength", power, duration));
                System.out.println(name + " used: strength +" + power + " for " + duration + " turns. Current strength: " + player.strength);
                break;

            default:
                System.out.println("Item has no recognizable effect: " + effect);
                break;
        }
    }

    // Call once per game turn to process active temporary effects.
    public static void tickAllEffects() {
        java.util.Iterator<java.util.Map.Entry<Player, java.util.List<StatusEffect>>> mapIt =
                activeEffects.entrySet().iterator();

        while (mapIt.hasNext()) {
            java.util.Map.Entry<Player, java.util.List<StatusEffect>> entry = mapIt.next();
            Player player = entry.getKey();
            java.util.List<StatusEffect> list = entry.getValue();

            java.util.Iterator<StatusEffect> it = list.iterator();
            while (it.hasNext()) {
                StatusEffect se = it.next();
                se.remainingTurns--;
                if (se.remainingTurns <= 0) {
                    // revert effect
                    if ("strength".equals(se.type)) {
                        player.strength -= se.amount;
                        if (player.strength < 0) player.strength = 0;
                        System.out.println("Strength buff expired for player. -" + se.amount + " strength. Current: " + player.strength);
                    }
                    // remove expired effect
                    it.remove();
                }
            }

            if (list.isEmpty()) {
                mapIt.remove();
            }
        }
    }

    private static void addStatusEffect(Player player, StatusEffect se) {
        java.util.List<StatusEffect> list = activeEffects.get(player);
        if (list == null) {
            list = new java.util.ArrayList<>();
            activeEffects.put(player, list);
        }
        list.add(se);
    }

    private static class StatusEffect {
        String type;
        int amount;
        int remainingTurns;

        StatusEffect(String type, int amount, int remainingTurns) {
            this.type = type;
            this.amount = amount;
            this.remainingTurns = remainingTurns;
        }
    }

    @Override
    public String toString() {
        return name + ": " + description + " (effect=" + effect + ", power=" + power + ", duration=" + duration + ")";
    }
}
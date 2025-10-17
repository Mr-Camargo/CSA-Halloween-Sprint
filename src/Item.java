import java.util.ArrayList;

/**
 * Item class represents objects that players can pick up and use.
 * As specified in README.md, items have name, description, and effect.
 */
class Item {
    String name;
    String description;
    String effect;

    /**
     * Constructor to create an item.
     * @param name The name of the item
     * @param description The description of the item
     * @param effect The effect the item has ("heal", "strength", "damage", etc.)
     */
    public Item(String name, String description, String effect) {
        this.name = name;
        this.description = description;
        this.effect = effect;
    }

    /**
     * Use the item on a player or monster.
     * @param player The player using the item
     * @param monster The monster being targeted (can be null)
     */
    public void use(Player player, Monster monster) {
        if (effect == null || effect.isEmpty()) {
            System.out.println("This item has no effect.");
            return;
        }

        switch (effect.toLowerCase()) {
            case "heal":
                int healAmount = 15;
                if (player.health >= 86) {
                    System.out.println("⚠️ Healing won't be as effective at high health!");
                }
                player.health += healAmount;
                if (player.health > 100) {
                    player.health = 100; // Cap health at 100
                }
                System.out.println("✨ You used " + name + " and healed " + healAmount + " HP! Current health: " + player.health);
                break;

            case "strength":
                int strengthBoost = 10;
                player.strength += strengthBoost;
                System.out.println("💪 You used " + name + " and gained " + strengthBoost + " strength! Current strength: " + player.strength);
                break;

            case "damage":
                if (monster != null && monster.isAlive()) {
                    int damageAmount = 20;
                    System.out.println("💥 You used " + name + " on the " + monster.name + "!");
                    monster.takeDamage(damageAmount);
                } else {
                    System.out.println("There's no monster to use this on!");
                }
                break;

            case "poison":
                if (monster != null && monster.isAlive()) {
                    int poisonDamage = 30;
                    System.out.println("☠️ You used " + name + " - the " + monster.name + " is poisoned!");
                    monster.takeDamage(poisonDamage);
                } else {
                    System.out.println("There's no monster to use this on!");
                }
                break;

            default:
                System.out.println("❓ You used " + name + " but nothing happened.");
                break;
        }
    }

    @Override
    public String toString() {
        return name + " (" + effect + ")";
    }
}

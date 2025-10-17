import java.util.ArrayList;
import java.util.Random;

/**
 * Base Monster class - represents enemies in the haunted house.
 * As specified in README.md, monsters have name, strength, and description.
 */
class Monster {
    String name;
    int strength;
    int health;
    String description;
    protected Random rand = new Random();

    /**
     * Constructor for creating a monster.
     */
    public Monster(String name, int strength, int health, String description) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.description = description;
    }

    /**
     * Default constructor for subclasses.
     */
    public Monster() {
        this.name = "Unknown Monster";
        this.strength = 5;
        this.health = 20;
        this.description = "A mysterious creature.";
    }

    /**
     * Describe the monster (as specified in README.md).
     */
    public void describe() {
        System.out.println(name + ": " + description);
        System.out.println("Strength: " + strength + " | Health: " + health);
    }

    /**
     * Attack the player (as specified in README.md).
     * Reduces player health based on monster strength.
     */
    public void attack(Player player) {
        player.health -= this.strength;
        System.out.println(this.name + " attacks you for " + this.strength + " damage! Your health is now: " + player.health);
    }

    /**
     * Check if the monster is still alive.
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Take damage from player.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " takes " + damage + " damage! Remaining health: " + this.health);
    }
}

/**
 * Skeleton monster - a spooky skeletal warrior with a chance to miss.
 */
class Skeleton extends Monster {
    public Skeleton() {
        this.name = "Skeleton";
        this.strength = 15;
        this.health = 40;
        this.description = "A spooky skeletal warrior wielding ancient bones.";
    }

    @Override
    public void attack(Player player) {
        if (rand.nextInt(100) < 20) {
            System.out.println(this.name + " swings at you but misses!");
        } else {
            player.health -= this.strength;
            System.out.println(this.name + " uses his spine and whips you! Your health is now: " + player.health);
        }
    }
}

/**
 * Zombie monster - slow and weak but relentless with high health.
 */
class Zombie extends Monster {
    public Zombie() {
        this.name = "Zombie";
        this.strength = 5;
        this.health = 110;
        this.description = "A slow and weak but relentless zombie.";
    }

    @Override
    public void attack(Player player) {
        if (rand.nextInt(100) < 20) {
            System.out.println(this.name + " lunges at you but misses!");
        } else {
            player.health -= this.strength;
            System.out.println(this.name + " bites and thrashes at you! Your health is now: " + player.health);
        }
    }
}

/**
 * Slime monster - gets stronger with each attack (ramping damage).
 */
class Slime extends Monster {
    private int attackCount = 0;

    public Slime() {
        this.name = "Slime";
        this.strength = 5;
        this.health = 40;
        this.description = "A small, gelatinous blob that grows stronger with each attack.";
    }

    @Override
    public void attack(Player player) {
        attackCount++;
        int rampedStrength = this.strength * attackCount;
        player.health -= rampedStrength;
        System.out.println(this.name + " spits acid at you! The slime acid burns stronger with each attack!");
        System.out.println("Damage dealt: " + rampedStrength + " | Your health is now: " + player.health);
    }
}

/**
 * Vampire monster - fast and deadly with life drain and bat summoning abilities.
 */
class Vampire extends Monster {
    private ArrayList<Bat> bats = new ArrayList<>();

    public Vampire() {
        this.name = "Vampire";
        this.strength = 40;
        this.health = 110;
        this.description = "A fast and deadly vampire with life-draining abilities.";
    }

    @Override
    public void attack(Player player) {
        int chance = rand.nextInt(100);
        if (chance < 30) {
            int damage = this.strength * 2;
            player.health -= damage;
            System.out.println(this.name + " swoops in and drains your life force! You feel weaker!");
            System.out.println("Damage dealt: " + damage + " | Your health is now: " + player.health);
        } else {
            player.health -= this.strength;
            System.out.println(this.name + " bites you! Your health is now: " + player.health);
        }

        if (bats.isEmpty()) {
            int numbBats = rand.nextInt(4) + 2;
            System.out.println(this.name + " summons " + numbBats + " bats to attack you!");
            for (int i = 0; i < numbBats; i++) {
                Bat bat = new Bat();
                bats.add(bat);
            }
        } else {
            int chance2 = rand.nextInt(100);
            if (chance2 < 30) {
                int moreBats = rand.nextInt(3) + 1;
                System.out.println(this.name + " summons " + moreBats + " more bats to attack you!");
                for (int i = 0; i < moreBats; i++) {
                    Bat bat = new Bat();
                    bats.add(bat);
                }
            }
        }

        for (int i = bats.size() - 1; i >= 0; i--) {
            Bat bat = bats.get(i);
            if (bat.isAlive()) {
                bat.attack(player);
            } else {
                bats.remove(i);
            }
        }
    }

    public ArrayList<Bat> getBats() {
        return bats;
    }
}

/**
 * Bat monster - small, weak creature often summoned by vampires.
 */
class Bat extends Monster {
    public Bat() {
        this.name = "Bat";
        this.strength = 2;
        this.health = 1;
        this.description = "A small, flying bat. Does minimal damage but attacks can add up.";
    }

    @Override
    public void attack(Player player) {
        if (rand.nextInt(100) < 30) {
            System.out.println(this.name + " swoops at you but misses!");
        } else {
            player.health -= this.strength;
            System.out.println(this.name + " swoops in and scratches you! Your health is now: " + player.health);
        }
    }
}

/**
 * Ghost monster - can phase in and out, making it tricky to fight.
 */
class Ghost extends Monster {
    private boolean isPhased = false;

    public Ghost() {
        this.name = "Ghost";
        this.strength = 10;
        this.health = 30;
        this.description = "A spooky ghost that can phase through attacks.";
    }

    @Override
    public void attack(Player player) {
        if (isPhased) {
            System.out.println(this.name + " is phased out and dodges your attacks!");
            isPhased = false;
        } else {
            if (rand.nextInt(100) < 25) {
                System.out.println(this.name + " phases through you and misses!");
            } else {
                player.health -= this.strength;
                System.out.println(this.name + " curses you! Your health is now: " + player.health);
            }
            isPhased = true;
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (isPhased) {
            System.out.println(this.name + " is phased and takes no damage!");
        } else {
            super.takeDamage(damage);
        }
    }
}
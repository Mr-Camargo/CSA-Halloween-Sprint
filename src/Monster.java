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
        this.strength = 15;
        this.health = 40;
        this.description = "A spooky skeletal warrior.";
    }
    @Override 
    public void attack(Player player) {
        if (rand .nextInt(100) < 20) { // 20% chance to miss
            System.out.println(this.name + " swings at you but misses!");
        } else {
          player.health -= this.strength;
        System.out.println(this.name + " uses his spine and whips you! Your health is now: " + player.health);
        }
        
    }
    class zombie extends Monster {
    public zombie() {
        this.name = "Zombie";
        this.strength = 10;
        this.health = 100;
        this.description = "A slow and weak but relentless zombie.";
    }
    @Override 
    public void attack(Player player) {
        if (rand .nextInt(100) < 20) { // 20% chance to miss
            System.out.println(this.name + " lunges at you but misses!");
        } else {
        player.health -= this.strength;
        System.out.println(this.name + " bites and thrashes at you! Your health is now: " + player.health);
    }  
    class slime extends Monster {
    public slime() {
        this.name = "Slime";
        this.strength = 5;
        this.health = 40;
        this.description = "A small, gelatinous blob.";
    }
    @Override //Im not gonna give the slime a miss chance it has its unique ability already
    public void attack(Player player) {s
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
    @Override 
    public void attack(Player player) {
        int chance = rand.nextInt(100);
        if (chance < 30) { // 30% chance to double damage
            System.out.println(this.name + " swoops in and drains your life force! You feel weaker! Your health is now: " + (player.health -= this.strength * 2));
            player.health -= this.strength * 2;
        } else {
            player.health -= this.strength;
            System.out.println(this.name + " bites you! Your health is now: " + player.health);
            
        }
    }
    //bat summon
int numbBats = rand.nextInt(3) + 2; // Summon 2 to 5 bats
System.out.println(this.name + " summons " + numbBats + " bats to attack you!");
for (int i = 0; i < numbBats; i++) {            
 Bat bat = new Bat();
        }

if (bats .is empty()) { 
    int chance = rand.nextInt(100);
    if (chance < 30) { // 30% chance to summon more bats
        int moreBats = rand.nextInt(3) + 1; // Summon 1 to 3 more bats
        System.out.println(this.name + " summons " + moreBats + " more bats to attack you!");
        for (int i = 0; i < moreBats; i++) {
            Bat bat = new Bat();
            bats.add(bat);
        }
    }
}

}

class Bat extends Monster {
    public Bat() {
        this.name = "Bat";
        this.strength = 2;
        this.health = 1;
        this.description = "A small, flying bat, Does minimal damage but attacks can add up.";
    }
    @Override 
    public void attack(Player player) {
        player.health -= this.strength;
        System.out.println(this.name + " swoops in and scratches you! Your health is now: " + player.health);
    }
}
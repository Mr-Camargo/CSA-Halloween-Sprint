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
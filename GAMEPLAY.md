# 🎮 How to Play the Haunted House Adventure Game

## Running the Game

### Compile and Run (PowerShell)
```powershell
# Compile all files
javac -d bin Main.java src/*.java

# Run the game
java -cp bin Main
```

### Alternative Single Command
```powershell
javac -d bin Main.java src/*.java; java -cp bin Main
```

---

## 🎯 Game Objective

Escape the haunted mansion by navigating through rooms, defeating monsters, and finding the **Exit Door** in the **Dusty Attic**!

---

## 🗺️ Room Map

```
Entrance Hall (START)
    ├── Dark Library → Haunted Bedroom → Dusty Attic → EXIT DOOR ✓
    └── Abandoned Kitchen → Creepy Basement → Dusty Attic → EXIT DOOR ✓
```

**Winning Path Example:**
1. Entrance Hall → Dark Library → Haunted Bedroom → Dusty Attic → Exit Door

---

## 🎮 Controls & Commands

### Main Actions (Outside Combat)
- **1** - Move to another room
- **2** - Pick up an item
- **3** - View inventory
- **4** - View status (health, strength, location)
- **5** - Look around (re-examine current room)
- **6** - Quit game

### Combat Actions
- **1** - Attack a monster
- **2** - Use an item from inventory
- **3** - Try to flee (escape to random exit)

---

## 👾 Monsters & Locations

| Monster | Location | Health | Strength | Special Ability |
|---------|----------|--------|----------|----------------|
| **Skeleton** | Dark Library, Creepy Basement | 40 | 15 | 20% miss chance |
| **Zombie** | Abandoned Kitchen | 100 | 10 | High HP, 20% miss |
| **Slime** | Creepy Basement | 40 | 5 | Ramping damage (gets stronger!) |
| **Ghost** | Haunted Bedroom | 30 | 10 | Phases in/out (dodges attacks) |
| **Vampire** | Dusty Attic (BOSS) | 120 | 40 | Life drain + bat summons |

---

## 🎒 Items & Effects

### Healing Items
- **Health Potion** - Restores 15 HP (found in multiple rooms)

### Strength Boosters
- **Rusty Sword** - Permanently increases strength by 10 (Entrance Hall)
- **Magic Amulet** - Permanently increases strength by 10 (Haunted Bedroom)

### Offensive Items
- **Ancient Scroll** - Deals 20 damage to a monster (Dark Library)
- **Holy Water** - Deals 20 damage to a monster (Dusty Attic)
- **Poison Vial** - Deals 30 damage to a monster (Creepy Basement)

---

## 💡 Strategy Tips

1. **Collect strength items first!** Visit Entrance Hall for the Rusty Sword before fighting.

2. **Stock up on health potions** - They're in Entrance Hall, Kitchen, and Attic.

3. **Save offensive items** for tough monsters (Ghost, Vampire).

4. **Fight strategically:**
   - Skeleton: Quick but fragile (40 HP)
   - Zombie: High HP but weak damage - wear it down
   - Slime: Kill FAST before damage ramps up!
   - Ghost: Time attacks when it's NOT phased
   - Vampire: BOSS - use all items, highest priority!

5. **Fleeing is an option** - If overwhelmed, flee and heal up!

6. **Recommended Path:**
   - Entrance Hall (grab Rusty Sword + Health Potion)
   - Dark Library (fight Skeleton, grab Ancient Scroll)
   - Haunted Bedroom (fight Ghost, grab Magic Amulet)
   - Dusty Attic (grab items, fight Vampire BOSS)
   - Exit Door → WIN!

---

## 📊 Player Stats

- **Starting Health:** 100 HP
- **Starting Strength:** 10 damage per attack
- **Max Health:** 100 HP (health potions won't exceed this)

---

## 🏆 Win Conditions

Reach the **Exit Door** room while still alive!

---

## 💀 Game Over

You die if your health reaches 0 or below. Monsters attack after every player action in combat!

---

## 🎃 Example Gameplay Session

```
[Game Start]
You are in Entrance Hall
Pick up: Rusty Sword (+10 strength!)
Pick up: Health Potion

Move to: Dark Library
⚔️ COMBAT! Skeleton (40 HP)
Attack Skeleton (10 damage) → 30 HP
Skeleton attacks (15 damage) → Your HP: 85
Attack Skeleton (10 damage) → 20 HP
Skeleton misses!
Attack Skeleton (10 damage) → 10 HP
Skeleton attacks (15 damage) → Your HP: 70
Attack Skeleton (10 damage) → 0 HP
✅ Skeleton defeated!

Continue exploring...
[Reach Exit Door]
🎉 YOU WIN! 🎉
```

---

## 🐛 Troubleshooting

**Game won't compile?**
```powershell
# Make sure you're in the project root directory
cd "C:\Users\...\CSA-Halloween-Sprint"

# Create bin directory if needed
mkdir bin

# Compile
javac -d bin Main.java src/*.java
```

**"Class not found" error?**
```powershell
# Make sure you use -cp bin when running
java -cp bin Main
```

---

## 🎨 Features Implemented

✅ **README.md Requirements:**
- Room navigation with ArrayList of exits
- Item pickup and inventory management
- Monster encounters with combat system
- Player health and strength mechanics
- Win/lose conditions

✅ **Enhanced Features:**
- Interactive menu system
- Combat system with attack/item/flee options
- Multiple monster types with unique abilities
- Strategic item placement
- Atmospheric text descriptions
- Victory and game over screens

---

**Enjoy your Halloween adventure! 🎃👻🦇**

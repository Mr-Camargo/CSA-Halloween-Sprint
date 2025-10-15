import java.util.ArrayList;

public class Rooms {
  public static void main(String[] action) {
    int roomNumber;

    String name;
    String description;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Room> exits = new ArrayList<>();

    public void enterRoom(int roomNumber) {
      switch (roomNumber) {
        case 1:
          name = "Haunted Hallway";
          description = "A long, dark hallway with flickering lights.";
          // items.add(new Item("Flashlight", "A handy flashlight to light your
          // way.", "Illuminates dark areas."));
          exits.add(2);
          break;
        case 2:
          name = "Creepy Kitchen";
          description =
              "An old kitchen with rusty utensils and a strange smell.";
          break;
        case 3:
          name = "Spooky Library";
          description = "A quiet library filled with dusty books and cobwebs.";
          break;
        default:
          name = "Unknown Room";
          description = "You are in an unfamiliar place.";
          break;
      }
    }

    private String respondAction(String action) {
      switch (action) {
        case "flashlightOnDarkRoom":
          ArrayList<String> answers = new ArrayList<>();
          answers.add("The flashlight illuminates the dark room.");
          answers.add("You grab your flashlight, but it seems to not be "
                      + "working. After a good shake, it flickers to life!");
          numberOfAnswers = answers.size();
          return answers.get((int) (Math.random() * numberOfAnswers));
        case "findKey":
          return "You found a rusty key hidden under the rug!";
        case "openDoor":
          return "The door creaks open, revealing a spooky corridor.";
        default:
          return "Action not recognized.";
      }
    }

    private String exits(String action) {
      switch (action) {
        case "getExits":
          ArrayList<String> exitNames = new ArrayList<>();
          for (Room exit : exits) {
            exitNames.add(exit.name);
          }
          return String.join(", ", exitNames);
        case "addExits":
          ArrayList<String> exitNames = new ArrayList<>();
          for (Room exit : exits) {
            exitNames.add(exit.name);
          }
          return String.join(", ", exitNames);
        default:
          return "No items found.";
      }
    }

    private String items(String action) {
      switch (action) {
        case "getItems":
          ArrayList<String> itemNames = new ArrayList<>();
          for (Item item : items) {
            itemNames.add(item.name);
          }
          return String.join(", ", itemNames);
        case "addItems":
          ArrayList<String> itemNames = new ArrayList<>();
          for (Item item : items) {
            itemNames.add(item.name);
          }
          return String.join(", ", itemNames);
        default:
          return "No items found.";
      }
    }
  }
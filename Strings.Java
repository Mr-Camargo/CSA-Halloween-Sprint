import java.util.ArrayList;

public class Strings {
  public static void main(String[] action) {
    int numberOfAnswers;

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
  }
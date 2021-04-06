package ca.minion.ui;
import ca.minion.model.Minion;
import ca.minion.model.MinionManager;
import java.util.Scanner;

/**
 * The purpose of this Class is to act as the User Interface,
 * it follows the user input and executes the corresponding command.
 * The Class also holds the core functionality of the commands
 */

public class MinionUI {

    private MinionManager manager;
    private String menuTitle = "Welcome to the Evil Minion Tracker (tm)";
    private String [] menuOption = {"List minions",
            "Add a new minion",
            "Remove a minion",
            "Attribute evil deed to a minion",
            "DEBUG: Dump objects (toString)",
            "Exit"};
    TextMenu menu = new TextMenu(menuTitle, menuOption);

    public MinionUI(MinionManager manager) {
        this.manager = manager;
    }

    public void show() {
        menu.displayMenuTitle();
        menu.displayMenuOptions();
        boolean isDone = false;
        while (!isDone) {
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    listOfMinions();
                    menu.displayMenuOptions();
                    break;

                case 2:
                    addMinion(in);
                    menu.displayMenuOptions();
                    break;

                case 3:
                    listOfMinions();
                    deleteMinion();
                    menu.displayMenuOptions();
                    break;

                case 4:
                    listOfMinions();
                    attributeEvilDeed();
                    menu.displayMenuOptions();
                    break;

                case 5:
                    debug();
                    menu.displayMenuOptions();
                    break;

                case 6:
                    isDone = true;
                    break;

                default:
                    System.out.println("Error! Please make a selection between 1 and " + menuOption.length);

            }
        }
    }

    private void listOfMinions() {
        System.out.println("List of minions:");
        System.out.println("****************");
        int count = 1;
        if (manager.size() > 0) {
            for (int i = 0; i < manager.size(); i++) {
                Minion minion = manager.getIndex(i);
                System.out.println(count + ". "
                        + minion.getName()
                        + ", " + minion.getHeight()
                        + "m, "
                        + minion.getNum_of_evil_deeds()
                        + " evil deed(s)");
                count++;
            }
        }
        else{
            System.out.println("No minions found.");
        }
    }

    private void addMinion(Scanner in) {
        System.out.println("Enter minion's name: ");
        String name = in.nextLine();
        name = in.nextLine();
        while(true) {
            System.out.println("Enter minion's height: ");
            double height = in.nextDouble();
            if (height < 0) {
                System.out.println("Error! height must be >=0.");
            } else {
                Minion m = new Minion(name, height);
                manager.add(m);
                break;
            }
        }
    }

    private void deleteMinion(){

        Scanner userInput = new Scanner(System.in);
        int index = getMinionIndex(userInput);
        if (index >= 0){
            manager.remove(index);
        }
    }

    private int getMinionIndex(Scanner userInput) {
        System.out.println("(Enter 0 to cancel)");

        while(true){
            int userChoice = userInput.nextInt();
            if (userChoice == 0){
                return -1;
            }
            else if (userChoice > 0 && userChoice <= manager.size()){
                return userChoice - 1;
            }
            else{
                System.out.println("Error! Please make a selection between 0 and " + manager.size() + "\n");

            }
        }
    }

    private void attributeEvilDeed(){
        Scanner userInput = new Scanner(System.in);
        int index = getMinionIndex(userInput);
        if(index < 0){
            return;
        }
        Minion minion = manager.getIndex(index);
        minion.addEvilDeeds();
    }

    private void debug() {
        System.out.println("All minion objects:");
        int count = 1;
        for (Minion minion : manager) {
            System.out.println(count + ". " + minion);
            count++;
        }
    }
}



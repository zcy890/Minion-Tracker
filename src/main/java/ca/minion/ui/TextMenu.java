package ca.minion.ui;

/**
 * The purpose of this Class is to display the menu title
 * and list the menu options. It is used by the MinionUI Class.
 */
public class TextMenu {
    private String menuTitle;
    private String[] menuOption;

    public TextMenu(String menuTitle, String[] menuOption) {
        this.menuTitle = menuTitle;
        this.menuOption = menuOption;
    }

    public void displayMenuTitle(){
        int titleLength = menuTitle.length();
        printAsterisk(titleLength);
        System.out.println("\n" + menuTitle + "\nby Zecheng Yan." );
        printAsterisk(titleLength);
        System.out.println("\n");
    }

    public void displayMenuOptions(){
        System.out.println("\n");
        System.out.println("*************");
        System.out.println("* Main Menu *");
        System.out.println("*************");
        for(int i = 0; i < menuOption.length; i++){
            System.out.println((i+1) + ". " + menuOption[i]);
        }
    }
    private void printAsterisk(int length) {
        for(int i = 0; i < length; i++){
            System.out.print("*");
        }
    }
}

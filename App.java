import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type App.
 */
public class App {

    /**
     * Instantiates a new App.
     */
    public App() {

    }

    protected static int getIntFromConsole(String message) {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        choice = scan.nextInt();
        return choice;
    }

    protected static String getStringFromConsole(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextLine();
    }

    public int showMenu(String title, String[] menuItems) {
        System.out.println(title);
        String ul = new String(new char[title.length()]).replace("\0", "-");
        System.out.println(ul);
        int i = 1;
        for (String menuItem : menuItems) {
            System.out.println(i++ + ") " + menuItem);
        }
        System.out.println("\n");
        int choice = getIntFromConsole(">");
        return choice;
    }

    /**
     * Show main menu.
     */
    public void showMainMenu() {
        while (true) {
            String[] menuItems = { "task list", "contact list", "quit"};
            int choice = showMenu("Select your Application", menuItems);
            if (choice == 1) {
                TaskApp taskApp = new TaskApp();
                taskApp.showMainMenu();
            }
            else if (choice == 2) {
                ContactApp contactApp = new ContactApp();
                contactApp.showMainMenu();
            }
            else if (choice == 3) {
                return;
            }
            else {
                System.out.println("Invalid number. Must be between 1 and 3\n");
            }
            System.out.println("\n");
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}

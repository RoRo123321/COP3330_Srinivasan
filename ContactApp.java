import java.util.ArrayList;

/**
 * The type App.
 */
public class ContactApp extends App {

    /**
     * Instantiates a new TaskApp.
     */
    public ContactApp() {

    }

    /**
     * Show main menu.
     */
    public void showMainMenu() {
        while (true) {
            String[] menuItems = {"create a new list", "load an existing list", "quit"};
            int choice = showMenu("Main Menu", menuItems);
            if (choice == 1) {
                ContactList contactList = createNewContactList();
                showListOperationMenu(contactList);
            }
            else if (choice == 2) {
                ContactList contactList = loadExistingContactList();
                showListOperationMenu(contactList);
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
     * Show list operation menu.
     *
     * @param contactList the task list
     */
    private void showListOperationMenu(ContactList contactList) {
        while (true) {
            String[] menuItems = {"view the list", "add an item", "edit an item", "remove an item",
                    "save the current list", "quit to the main menu"};
            int choice = showMenu("List Operation Menu", menuItems);
            switch(choice) {
                case 1:
                    viewContactList(contactList);
                    break;
                case 2:
                    addContactItem(contactList);
                    break;
                case 3:
                    editContactItem(contactList);
                    break;
                case 4:
                    removeContactItem(contactList);
                    break;
                case 5:
                    saveCurrentList(contactList);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid number. Must be between 1 and 6\n");
                    break;
            }
        }
    }

    /**
     * Create new task list task list.
     *
     * @return the task list
     */
    private ContactList createNewContactList() {
        ContactList contactList = new ContactList();
        System.out.println("new task list has been created\n");
        return  contactList;
    }

    /**
     * Load existing task list task list.
     *
     * @return the task list
     */
    private ContactList loadExistingContactList() {
        String fileName = getStringFromConsole("Enter the filename to load:");
        try {
            ContactList contactList = ContactList.loadExistingContactList(fileName);
            System.out.println("task list has been loaded");
            return  contactList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * View task list.
     *
     * @param contactList the task list
     */
    private void viewContactList(ContactList contactList) {
        System.out.println("Current Contacts");
        System.out.println("----------------\n");
        ArrayList<Item> items = contactList.getItems();
        for(int i=0; i<items.size(); i++) {
            //Cast it to the right object
            ContactItem item = (ContactItem)items.get(i);
            String outStr = i + ")";
            outStr = outStr + " Name: " + item.getFirstName() + " " + item.getLastName() + "\n";
            outStr = outStr + "Phone: " + item.getPhoneNumber() + "\n";
            outStr = outStr + "Email: " + item.getEmailAddress() + "\n";
            System.out.print(outStr);
        }
        System.out.println("\n\n");
    }

    /**
     * Add task item.
     *
     * @param contactList the task list
     */
    private void addContactItem(ContactList contactList) {
        String firstName = getStringFromConsole("First Name: ");
        String lastName = getStringFromConsole("Last Name: ");
        String phoneNumber = getStringFromConsole("Phone number (xxx-xxx-xxxx): ");
        String emailAddress = getStringFromConsole("Email address (x@y.z): ");

        try {
            ContactItem item = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            contactList.addItem(item);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Edit task item.
     *
     * @param contactList the task list
     */
    private void editContactItem(ContactList contactList) {
        viewContactList(contactList);
        int index = getIntFromConsole("Which contact will you edit? ");

        try {
            ContactItem contactItem = (ContactItem) contactList.getItem(index);

            String firstName = getStringFromConsole("Enter a new First Name for contact " + index + ": ");
            String lastName = getStringFromConsole("Enter a new Last Name for contact " + index + ": ");
            String phoneNumber = getStringFromConsole("Enter a new Phone number (xxx-xxx-xxxx) for contact " + index + ": ");
            String emailAddress = getStringFromConsole("Enter a new Email address (x@y.z) for contact " + index + ": ");

            contactItem.setValues(firstName, lastName, phoneNumber, emailAddress);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Remove task item.
     *
     * @param contactList the task list
     */
    private void removeContactItem(ContactList contactList) {
        viewContactList(contactList);
        int index = getIntFromConsole("Which task will you delete? ");
        try {
            contactList.removeItem(index);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
        System.out.println("\n");
    }

    /**
     * Save current list.
     *
     * @param contactList the task list
     */
    private void saveCurrentList(ContactList contactList) {
        String fileName = getStringFromConsole("Enter the filename to save: ");
        if (fileName == null || fileName.length() == 0) {
            System.out.println("file name not entered");
        }
        try {
            contactList.saveCurrentList(fileName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
        System.out.println("\n");
    }

}

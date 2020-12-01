import java.io.*;
import java.util.ArrayList;

/**
 * The type Contact list.
 */
public class ContactList extends ItemList {

    /**
     * Instantiates a new Contact list.
     */
    public ContactList() {
    }

    /**
     * Load existing contact list contact list.
     *
     * @param fileName the file name
     * @return the contact list
     */
    public static ContactList loadExistingContactList(String fileName)  {
        ContactList contactList = new ContactList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    contactList.addItem(ContactItem.getItemFromLine(line, "\\|"));
                }
                catch(Exception e1) {
                    System.out.println(e1.getMessage() + " " + line);
                }
            }
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {}
            }
        }
        return contactList;
    }

}

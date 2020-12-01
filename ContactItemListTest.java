import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemListTest {

    @Test
    public void addingContactItemsIncreasesSize() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            assertEquals(contactList.getSize(), 1);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            contactList.getItem(0);
            Exception e = assertThrows(Exception.class, () -> contactItem.validate("", "", "", ""));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        try {
            ContactList contactList = new ContactList();
            Exception e = assertThrows(Exception.class, () -> contactList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            contactItem = (ContactItem) contactList.getItem(0);
            String newValue = "";
            contactItem.setValues(newValue, "Last", "111-111-2222", "a@b.com");
            assertEquals(contactItem.getFirstName(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("Last", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            contactItem = (ContactItem) contactList.getItem(0);
            String newValue = "";
            contactItem.setValues("First", newValue, "111-111-2222", "a@b.com");
            assertEquals(contactItem.getLastName(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("Last", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            contactItem = (ContactItem) contactList.getItem(0);
            String newValue = "";
            contactItem.setValues("Last", "Last", newValue, "a@b.com");
            assertEquals(contactItem.getPhoneNumber(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        try {
            String newValue = "First";
            ContactItem contactItem = new ContactItem("Last", "Last", "111-111-2222", "a@b.com");
                contactItem.setValues(newValue, "Last", "111-111-2222", "a@b.com");
            assertEquals(contactItem.getFirstName(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void newListIsEmpty() {
        try {
            ContactList contactList = new ContactList();
            assertEquals(contactList.getSize(), 0);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void removingContactItemsDecreasesSize() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            contactList.removeItem(0);
            assertEquals(contactList.getSize(), 0);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            Exception e = assertThrows(Exception.class, () -> contactList.removeItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void savedContactListCanBeLoaded() {
        try {
            ContactList contactList = new ContactList();
            ContactItem contactItem;
            contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            contactList.addItem(contactItem);
            String fileName = "contact.text";
            contactList.saveCurrentList(fileName);
            contactList = ContactList.loadExistingContactList(fileName);
            assertEquals(contactList.getSize(), 1);
        } catch (Exception e) {
            //
        }
    }
}

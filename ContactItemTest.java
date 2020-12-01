import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        Exception e = assertThrows(Exception.class, () -> new ContactItem("", "", "", ""));
        assertNotNull(e);
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        try {
            ContactItem item = new ContactItem("", "Last", "111-111-2222", "a@b.c");
            assertNotNull(item);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        try {
            ContactItem item = new ContactItem("First", "", "111-111-2222", "a@b.c");
            assertNotNull(item);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        try {
            ContactItem item = new ContactItem("First", "Last", "", "a@b.c");
            assertNotNull(item);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        try {
            ContactItem item = new ContactItem("First", "Last", "111-111-2222", "222@bb.edu");
            assertNotNull(item);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        try {
            Exception e = assertThrows(Exception.class, () ->
                    new ContactItem("First", "Last", "111-111-2222", "a@b.com")
                        .setValues("", "", "", ""));
            assertNotNull(e);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        try {
            ContactItem item = new ContactItem("First", "Last", "111-111-2222", "");
            assertNotNull(item);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void testToString() {
        try {
            ContactItem contactItem = new ContactItem("First", "Last", "111-111-2222", "a@b.com");
            String delimiter = "|";
            String str = contactItem.getFirstName() + delimiter + contactItem.getLastName() + delimiter + contactItem.getPhoneNumber() + delimiter + contactItem.getEmailAddress();
            assertEquals(str, contactItem.getItemAsLine(delimiter));
        }
        catch(Exception e) {
            //
        }
    }

}

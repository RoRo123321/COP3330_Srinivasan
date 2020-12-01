/**
 * The type Contact item.
 */
public class ContactItem implements Item {
    private String firstName="";
    private String lastName="";
    private String phoneNumber="";
    private String emailAddress="";

    /**
     * Instantiates a new Contact item.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param phoneNumber  the phone number
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        validate(firstName, lastName, phoneNumber, emailAddress);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     * @throws Exception the exception
     */
    private void setPhoneNumber(String phoneNumber) throws Exception {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Validate phone number.
     *
     * @param phoneNumber the phone number
     * @throws Exception the exception
     */
    public void validatePhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber != null && phoneNumber.length() > 0) {
            String[] tokens = phoneNumber.split("-");
            if (tokens.length != 3) {
                throw new Exception("Invalid Phone Number. Must be in the format xxx-xxx-xxxx");
            }
            if (tokens[0].length() != 3 || tokens[1].length() != 3 || tokens[2].length() != 4) {
                throw new Exception("Invalid Phone Number. Must be in the format xxx-xxx-xxxx");
            }
        }
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    private void setEmailAddress(String emailAddress) throws Exception {
        this.emailAddress = emailAddress;
    }

    /**
     * Validate email address.
     *
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public void validateEmailAddress(String emailAddress) throws Exception {
        if (emailAddress != null && emailAddress.length() > 0) {
            String[] tokens = emailAddress.split("@");
            if (tokens.length != 2) {
                throw new Exception("Invalid Email Address. Must be in the format x@y.z");
            }
            if (!tokens[1].contains(".")) {
                throw new Exception("Invalid Email Address. Must be in the format x@y.z");
            }
        }
    }

    /**
     * Validate.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param phoneNumber  the phone number
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public void setValues (String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        validate(firstName, lastName, phoneNumber, emailAddress);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }

    /**
     * Validate.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param phoneNumber  the phone number
     * @param emailAddress the email address
     * @throws Exception the exception
     */
    public void validate (String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        validatePhoneNumber(phoneNumber);
        validateEmailAddress(emailAddress);
        if ((null == firstName || firstName.length() == 0) &&
                (null == lastName || lastName.length() == 0) &&
                (null == phoneNumber || phoneNumber.length() == 0) &&
                (null == emailAddress || emailAddress.length() == 0)) {
            throw  new Exception("At least one of First Name, Last Name, Phone Number and Email must not be empty");
        }
    }

    /**
     * Gets item as line.
     *
     * @param delimiter the delimiter
     * @return the item as line
     */
    public String getItemAsLine(String delimiter) {
        return getFirstName() + delimiter + getLastName() + delimiter + getPhoneNumber() + delimiter + getEmailAddress();
    }

    /**
     * Gets item from line.
     *
     * @param line      the line
     * @param regularExpression the delimiter
     * @return the item from line
     * @throws Exception the exception
     */
    public static ContactItem getItemFromLine(String line, String regularExpression) throws Exception {
        String[] tokens = line.split(regularExpression, -1);
        if (tokens.length != 4) {
            throw new Exception("Invalid record in file " + line);
        }
        ContactItem item = new ContactItem(tokens[0], tokens[1], tokens[2], tokens[3]);
        return item;
    }

}

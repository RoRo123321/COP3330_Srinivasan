import java.text.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Task item.
 */
public class TaskItem implements Item {
    private String title;
    private String description;
    private Date dueDate;
    private boolean isComplete;

    /**
     * Instantiates a new Task item.
     *
     * @param title       the title
     * @param description the description
     * @param dueDateStr  the due date str
     * @throws Exception the exception
     */
    public TaskItem(String dueDateStr, String title, String description) throws Exception{
        validate(title, dueDateStr);
        setTitle(title);
        setDescription(description);
        setDueDate(dueDateStr);
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     * @throws Exception the exception
     */
    private void setTitle(String title) throws  Exception {
        this.title = title;
    }

    /**
     * Validate title.
     *
     * @param title the title
     * @throws Exception the exception
     */
    private void validateTitle(String title) throws Exception {
        if (title == null || title.length() == 0) {
            throw new Exception("Title must be 1 or more characters in length");
        }
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Gets due date as string.
     *
     * @return the due date as string
     */
    public String getDueDateAsString() {
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(getDueDate());
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    private void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDateStr the due date str
     * @throws Exception the exception
     */
    private void setDueDate(String dueDateStr) throws  Exception {
        this.dueDate = validateDueDate(dueDateStr);
    }

    public Date validateDueDate(String dueDateStr) throws Exception {
        Date inDate;
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            inDate = sdf.parse(dueDateStr);
        }
        catch (Exception e) {
            throw new Exception ("invalid date");
        }
        return inDate;
    }

    /**
     * Is complete boolean.
     *
     * @return the boolean
     */
    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Sets complete.
     *
     * @param complete the complete
     */
    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String toString() {
        return "[" + getDueDateAsString() + "] " + getTitle() + ": " + getDescription();
    }

    /**
     * Validate.
     *
     * @param title      the title
     * @param dueDateStr the due date str
     * @throws Exception the exception
     */
    private void validate(String title, String dueDateStr) throws Exception {
        validateTitle(title);
        validateDueDate(dueDateStr);
    }

    public void setValues(String title, String description, String dueDateStr) throws Exception {
        validate(title, dueDateStr);
        setTitle(title);
        setDescription(description);
        setDueDate(dueDateStr);
    }

    /**
     * Gets item as line.
     *
     * @param delimiter the delimiter
     * @return the item as line
     */
    public String getItemAsLine(String delimiter) {
        return getDueDateAsString() + delimiter + getTitle() + delimiter + getDescription() + delimiter + isComplete();
    }

    /**
     * Gets item from line.
     *
     * @param line      the line
     * @param regularExpression the delimiter
     * @return the item from line
     * @throws Exception the exception
     */
    public static TaskItem getItemFromLine(String line, String regularExpression) throws Exception {
        String[] tokens = line.split(regularExpression);
        if (tokens.length != 4) {
            throw new Exception("Invalid record in file " + line);
        }
        TaskItem item = new TaskItem(tokens[0], tokens[1], tokens[2]);
        item.setComplete(tokens[3].equalsIgnoreCase("true"));
        return item;
    }

}

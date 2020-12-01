import java.io.*;

/**
 * The type Task list.
 */
public class TaskList extends ItemList {

    /**
     * Instantiates a new Task list.
     */
    public TaskList() {
    }

    private void toggleBookMark(int index, boolean toggle) throws Exception {
        if (index < 0 || index >= getItems().size() ) {
            throw new Exception("Invalid task number");
        }
        TaskItem taskItem = (TaskItem) getItems().get(index);
        taskItem.setComplete(toggle);
    }

    /**
     * Mark task item as complete.
     *
     * @param index the index
     * @throws Exception the exception
     */
    public void markTaskItemAsComplete(int index) throws Exception {
        toggleBookMark(index, true);
    }

    /**
     * Unmark task item as complete.
     *
     * @param index the index
     * @throws Exception the exception
     */
    public void unmarkTaskItemAsComplete(int index) throws Exception {
        toggleBookMark(index, false);
    }

    /**
     * Load existing task list task list.
     *
     * @param fileName the file name
     * @return the task list
     */
    public static TaskList loadExistingTaskList(String fileName) {
        TaskList taskList = new TaskList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // process the line
                    taskList.addItem(TaskItem.getItemFromLine(line, "\\|"));
                }
                catch(Exception e1) {
                    System.out.println(e1.getMessage());
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
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return taskList;
    }

}

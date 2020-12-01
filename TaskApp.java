import java.util.ArrayList;

/**
 * The type App.
 */
public class TaskApp extends App {

    /**
     * Instantiates a new TaskApp.
     */
    public TaskApp() {

    }

    /**
     * Show main menu.
     */
    public void showMainMenu() {
        while (true) {
            String[] menuItems = {"create a new list", "load an existing list", "quit"};
            int choice = showMenu("Main Menu", menuItems);
            if (choice == 1) {
                TaskList taskList = createNewTaskList();
                showListOperationMenu(taskList);
            }
            else if (choice == 2) {
                TaskList taskList = loadExistingTaskList();
                showListOperationMenu(taskList);
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
     * @param taskList the task list
     */
    private void showListOperationMenu(TaskList taskList) {
        while (true) {
            String[] menuItems = {"view the list", "add an item", "edit an item", "remove an item", "mark an item as completed",
                    "unmark an item as completed", "save the current list", "quit to the main menu"};
            int choice = showMenu("List Operation Menu", menuItems);
            switch(choice) {
                case 1:
                    viewTaskList(taskList, "Current Tasks");
                    break;
                case 2:
                    addTaskItem(taskList);
                    break;
                case 3:
                    editTaskItem(taskList);
                    break;
                case 4:
                    removeTaskItem(taskList);
                    break;
                case 5:
                    markTaskItemAsComplete(taskList);
                    break;
                case 6:
                    unmarkTaskItemAsComplete(taskList);
                    break;
                case 7:
                    saveCurrentList(taskList);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid number. Must be between 1 and 8\n");
                    break;
            }
        }
    }

    /**
     * Create new task list task list.
     *
     * @return the task list
     */
    private TaskList createNewTaskList() {
        TaskList taskList = new TaskList();
        System.out.println("new task list has been created\n");
        return  taskList;
    }

    /**
     * Load existing task list task list.
     *
     * @return the task list
     */
    private TaskList loadExistingTaskList() {
        String fileName = getStringFromConsole("Enter the filename to load:");
        try {
            TaskList taskList = TaskList.loadExistingTaskList(fileName);
            System.out.println("task list has been loaded");
            return  taskList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * View task list.
     *
     * @param taskList the task list
     * @param type     the type
     */
    private void viewTaskList(TaskList taskList, String type) {
        System.out.println(type);
        System.out.println("-------------\n");
        ArrayList<Item> items = taskList.getItems();
        for(int i=0; i<items.size(); i++) {
            //0) [2020-01-01] Task 1: My first task
            TaskItem item = (TaskItem) items.get(i);
            if ((type.equals("Completed Tasks") && !item.isComplete()) || (type.equals("Uncompleted Tasks") && item.isComplete())) {
                //skip if a completed task when user is trying to complete the task or
                //skip if an uncompleted task when user is trying to un-complete the task
                continue;
            }
            String outStr = i + ")";
            if (item.isComplete()) {
                outStr = outStr + " ***";
            }
            outStr = outStr + " [" + item.getDueDateAsString() + "] " + item.getTitle() + ": " + item.getDescription() + "\n";
            System.out.print(outStr);
        }
        System.out.println("\n\n");
    }

    /**
     * Add task item.
     *
     * @param taskList the task list
     */
    private void addTaskItem(TaskList taskList) {
        String title = getStringFromConsole("Task title: ");
        String description = getStringFromConsole("Task description: ");
        String dueDateStr = getStringFromConsole("Task due date (YYYY-MM-DD): ");

        try {
            TaskItem item = new TaskItem(title, description, dueDateStr);
            taskList.addItem(item);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Edit task item.
     *
     * @param taskList the task list
     */
    private void editTaskItem(TaskList taskList) {
        viewTaskList(taskList, "Current Tasks");
        int index = getIntFromConsole("Which task will you edit? ");

        try {
            TaskItem taskItem = (TaskItem) taskList.getItem(index);

            String title = getStringFromConsole("Enter a new title for task " + index + ": ");
            String description = getStringFromConsole("Enter a new description for task " + index + ": ");
            String dueDateStr = getStringFromConsole("Enter a new date (YYYY-MM-DD) for task " + index + ": ");

            taskItem.setValues(title, description, dueDateStr);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Remove task item.
     *
     * @param taskList the task list
     */
    private void removeTaskItem(TaskList taskList) {
        viewTaskList(taskList, "Current Tasks");
        int index = getIntFromConsole("Which task will you delete? ");
        try {
            taskList.removeItem(index);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Mark task item as complete.
     *
     * @param taskList the task list
     */
    private void markTaskItemAsComplete(TaskList taskList) {
        viewTaskList(taskList, "Uncompleted Tasks");
        int index = getIntFromConsole("Which task will you mark as completed? ");
        try {
            taskList.markTaskItemAsComplete(index);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Unmark task item as complete.
     *
     * @param taskList the task list
     */
    private void unmarkTaskItemAsComplete(TaskList taskList) {
        viewTaskList(taskList, "Completed Tasks");
        int index = getIntFromConsole("Which task will you unmark as completed? ");
        try {
            taskList.unmarkTaskItemAsComplete(index);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n");
    }

    /**
     * Save current list.
     *
     * @param taskList the task list
     */
    private void saveCurrentList(TaskList taskList) {
        String fileName = getStringFromConsole("Enter the filename to save:");
        if (fileName == null || fileName.length() == 0) {
            System.out.println("file name not entered");
        }
        try {
            taskList.saveCurrentList(fileName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

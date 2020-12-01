import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        Exception e = assertThrows(Exception.class, () -> new TaskItem("Task1", "Description 1", "222-22-222"));
        assertNotNull(e);
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        Exception e = assertThrows(Exception.class, () -> new TaskItem("", "Description 1", "2020-01-01"));
        assertNotNull(e);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        try {
            TaskItem taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            assertNotNull(taskItem);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        try {
            TaskItem taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            assertNotNull(taskItem);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void settingTaskItemFailsWithInvalidDueDate() {
        try {
            Exception e = assertThrows(Exception.class, () ->
                    new TaskItem("Task1", "Description 1", "2020-01-01")
                            .setValues("Task1", "Description 1","2222-111-1"));
            assertNotNull(e);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void settingTaskItemFailsWithInvalidTitle() {
        try {
            Exception e = assertThrows(Exception.class, () ->
                    new TaskItem("Task1", "Description 1", "2020-01-01")
                            .setValues("Task1", "Description 1",""));
            assertNotNull(e);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void settingTaskItemSucceedsWithValidDueDate() {
        TaskItem taskItem = null;
        try {
            String newValue = "2021-01-01";
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskItem.setValues("Task1", "Description 1", newValue);
            assertEquals(taskItem.getDueDateAsString(), newValue);
        }
        catch(Exception e) {
            //
        }
    }

    @Test
    public void settingTaskItemSucceedsWithValidTitle() {
        TaskItem taskItem = null;
        try {
            String newValue = "New Task1";
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskItem.setValues("Task1", "Description 1", newValue);
            assertEquals(taskItem.getTitle(), newValue);
        }
        catch(Exception e) {
            //
        }
    }

}
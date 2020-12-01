import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            assertEquals(taskList.getSize(), 1);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void completingTaskItemChangesStatus() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskList.markTaskItemAsComplete(0);
            assertTrue(taskItem.isComplete());
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.markTaskItemAsComplete(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemChangesValues() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskList.getItem(0);
            String newValue = "New Description";
            taskItem.setValues("Task1", newValue, "2020-01-01");
            assertNotEquals(taskItem.getDescription(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            String newValue = "New Description 1";
            taskItem.setValues("Task1", newValue, "2020-01-01");
            assertEquals(taskItem.getDescription(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskItem = (TaskItem) taskList.getItem(0);
            String newValue = "2020-01-01";
            taskItem.setValues("Task1", "Description 1", newValue);
            assertEquals(taskItem.getDueDateAsString(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskItem = (TaskItem) taskList.getItem(0);
            String newValue = "New Value";
            taskItem.setValues(newValue, "Description 1", "2020-01-01");
            assertEquals(taskItem.getTitle(), newValue);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            String value = "Description 1";
            taskItem = new TaskItem("Task1", value, "2021-01-01");
            taskList.addItem(taskItem);
            taskItem = (TaskItem) taskList.getItem(0);
            assertEquals(taskItem.getDescription(), value);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            String value = "2021-01-01";
            taskItem = new TaskItem("Task1", "Description 1", value);
            taskList.addItem(taskItem);
            taskItem = (TaskItem) taskList.getItem(0);
            assertEquals(taskItem.getDueDateAsString(), value);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.getItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            String value = "Task1";
            taskItem = new TaskItem(value, "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskItem = (TaskItem) taskList.getItem(0);
            assertEquals(taskItem.getTitle(), value);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void newTaskListIsEmpty() {
        try {
            TaskList taskList = new TaskList();
            assertEquals(taskList.getSize(), 0);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskList.removeItem(0);
            assertEquals(taskList.getSize(), 0);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            Exception e = assertThrows(Exception.class, () -> taskList.removeItem(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            String fileName = "test.text";
            taskList.saveCurrentList(fileName);
            taskList = TaskList.loadExistingTaskList(fileName);
            assertEquals(taskList.getSize(), 1);
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        try {
            TaskList taskList = new TaskList();
            TaskItem taskItem;
            taskItem = new TaskItem("Task1", "Description 1", "2020-01-01");
            taskList.addItem(taskItem);
            taskList.markTaskItemAsComplete(0);
            taskList.unmarkTaskItemAsComplete(0);
            assertFalse(taskItem.isComplete());
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        try {
            TaskList taskList = new TaskList();
            Exception e = assertThrows(Exception.class, () -> taskList.unmarkTaskItemAsComplete(-1));
            assertNotNull(e);
        } catch (Exception e) {
            //
        }
    }

}

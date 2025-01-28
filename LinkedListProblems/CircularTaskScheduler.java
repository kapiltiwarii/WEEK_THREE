class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail's next to new head
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Update tail's next to head
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position <= 0 || head == null) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task temp = head;
            int count = 1;
            while (count < position - 1 && temp.next != head) {
                temp = temp.next;
                count++;
            }
            newTask.next = temp.next;
            temp.next = newTask;
            if (temp == tail) {
                tail = newTask;
                tail.next = head;
            }
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        Task prev = null;

        // Check if the head needs to be removed
        if (head.taskId == taskId) {
            if (head == tail) { // Single element in the list
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Update tail's next to new head
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }

        // Traverse the list to find the task to remove
        while (temp != tail) {
            prev = temp;
            temp = temp.next;

            if (temp.taskId == taskId) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                    tail.next = head; // Update tail's next to head
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
        }

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: " + current);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");

        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }
    }

    // Search for tasks by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        boolean found = false;

        System.out.println("Tasks with priority " + priority + ":");

        while (true) {
            if (temp.priority == priority) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

// Main class to test the Task Scheduler
public class CircularTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Task A", 2, "2025-01-30");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-01-31");
        scheduler.addTaskAtBeginning(3, "Task C", 3, "2025-02-01");
        scheduler.addTaskAtPosition(4, "Task D", 2, "2025-02-02", 2);

        System.out.println("\nDisplaying all tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nView current task:");
        scheduler.viewCurrentTask();

        System.out.println("\nView current task again:");
        scheduler.viewCurrentTask();

        System.out.println("\nSearching tasks with priority 2:");
        scheduler.searchTaskByPriority(2);

        System.out.println("\nRemoving task with ID 2:");
        scheduler.removeTaskById(2);

        System.out.println("\nDisplaying all tasks after removal:");
        scheduler.displayAllTasks();
    }
}

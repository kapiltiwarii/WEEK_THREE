class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Process ID: " + processId + ", Burst Time: " + burstTime + ", Priority: " + priority;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add a new process at the end of the circular linked list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular link
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        Process current = head;
        Process prev = null;

        do {
            if (current.processId == processId) {
                if (current == head && current == tail) {
                    // Only one process in the list
                    head = tail = null;
                } else if (current == head) {
                    // Removing head process
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    // Removing tail process
                    tail = prev;
                    tail.next = head;
                } else {
                    // Removing a middle process
                    prev.next = current.next;
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Display all processes in the circular list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in the Circular Queue:");
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate the round-robin scheduling algorithm
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;

        System.out.println("\nStarting Round Robin Scheduling Simulation:");
        Process current = head;

        while (true) {
            boolean allProcessesCompleted = true;
            Process start = current; // Keep track of where we start each round

            do {
                if (current.burstTime > 0) {
                    allProcessesCompleted = false;

                    // Simulate the time quantum
                    int executionTime = Math.min(current.burstTime, timeQuantum);
                    current.burstTime -= executionTime;

                    // Calculate waiting time and turnaround time
                    if (current.burstTime == 0) {
                        completedProcesses++;
                        totalTurnaroundTime += totalWaitingTime + executionTime;
                    }

                    totalWaitingTime += executionTime;
                    System.out.println("Process ID " + current.processId + " executed for " + executionTime + " units. Remaining Burst Time: " + current.burstTime);

                    // Remove the process if its burst time is completed
                    if (current.burstTime == 0) {
                        removeProcess(current.processId);
                    }
                }

                current = current.next;
            } while (current != start);

            if (allProcessesCompleted) break; // Exit when all processes are completed

            // Display the state of the circular queue after each round
            displayProcesses();
        }

        // Display average waiting and turnaround times
        System.out.println("\nSimulation Complete.");
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) completedProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) completedProcesses));
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes to the scheduler
        scheduler.addProcess(1, 10, 3);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        System.out.println("Initial State of Processes:");
        scheduler.displayProcesses();

        // Simulate Round Robin Scheduling with a time quantum of 4
        scheduler.simulateRoundRobin(4);
    }
}

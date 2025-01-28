class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next; // Points to the next ticket (circular linked list)

    // Constructor
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket last; // Points to the last node of the circular linked list
    private int ticketCount; // Keeps track of the total number of tickets

    // Constructor
    public TicketReservationSystem() {
        this.last = null;
        this.ticketCount = 0;
    }

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) { // If the list is empty
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        ticketCount++;
        System.out.println("Ticket added successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets available to remove.");
            return;
        }

        Ticket current = last.next, prev = last;
        boolean found = false;

        // Traverse the circular linked list
        do {
            if (current.ticketId == ticketId) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        if (found) {
            if (current == last && current.next == last) { // Only one ticket in the list
                last = null;
            } else if (current == last) { // Removing the last ticket
                prev.next = last.next;
                last = prev;
            } else { // Removing a ticket from the middle or start
                prev.next = current.next;
            }
            ticketCount--;
            System.out.println("Ticket removed successfully!");
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        }
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = last.next;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId +
                    ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName +
                    ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = last.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found Ticket - Ticket ID: " + current.ticketId +
                        ", Customer Name: " + current.customerName +
                        ", Movie Name: " + current.movieName +
                        ", Seat Number: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for keyword: " + keyword);
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return ticketCount;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(1, "Alice", "Avengers", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Spiderman", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Batman", "C3", "02:00 PM");

        // Displaying tickets
        system.displayTickets();

        // Searching for a ticket
        system.searchTicket("Alice");
        system.searchTicket("Batman");

        // Removing a ticket
        system.removeTicket(2);
        system.displayTickets();

        // Display total tickets
        System.out.println("Total tickets booked: " + system.getTotalTickets());
    }
}

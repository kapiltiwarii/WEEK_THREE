class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev;
    Book next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Book Title: " + title + ", Author: " + author + ", Genre: " + genre +
                ", Book ID: " + bookId + ", Availability: " + (isAvailable ? "Available" : "Not Available");
    }
}

class LibraryManagementSystem {
    private Book head = null;
    private Book tail = null;

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a new book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (position <= 0 || head == null) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
        } else {
            Book temp = head;
            int count = 1;
            while (temp != null && count < position) {
                if (temp.next == null) break; // If position is out of bounds, append to the end
                temp = temp.next;
                count++;
            }
            newBook.next = temp.next;
            if (temp.next != null) temp.next.prev = newBook;
            temp.next = newBook;
            newBook.prev = temp;

            if (newBook.next == null) tail = newBook; // Update tail if added at the end
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next; // If removing head

                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev; // If removing tail

                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Title
    public void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with Title '" + title + "' not found.");
    }

    // Search for a book by Author
    public void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book by Author '" + author + "' not found.");
    }

    // Update a book’s Availability Status
    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID " + bookId + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("Books in Forward Order:");
        Book temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("Books in Reverse Order:");
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public void countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }
}

// Main class to test the Library Management System
public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 101, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addBookAtBeginning("1984", "George Orwell", "Dystopian", 103, false);
        library.addBookAtPosition("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        System.out.println("\nDisplaying books in forward order:");
        library.displayBooksForward();

        System.out.println("\nDisplaying books in reverse order:");
        library.displayBooksReverse();

        System.out.println("\nSearching for book by Title '1984':");
        library.searchBookByTitle("1984");

        System.out.println("\nSearching for book by Author 'Harper Lee':");
        library.searchBookByAuthor("Harper Lee");

        System.out.println("\nUpdating availability of Book ID 103:");
        library.updateBookAvailability(103, true);

        System.out.println("\nCounting total books:");
        library.countTotalBooks();

        System.out.println("\nRemoving Book ID 104:");
        library.removeBookById(104);

        System.out.println("\nDisplaying books in forward order after removal:");
        library.displayBooksForward();
    }
}

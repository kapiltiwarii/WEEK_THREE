class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie prev;
    Movie next;

    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieLinkedList {
    private Movie head;
    private Movie tail;

    // Add Movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add Movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add Movie at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 1) {
            System.out.println("Position must be greater than 0");
            return;
        }
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie current = head;
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current == null) {
            addAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.prev = current.prev;
            newMovie.next = current;
            if (current.prev != null) {
                current.prev.next = newMovie;
            }
            current.prev = newMovie;
        }
    }

    // Remove Movie by Title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Movie '" + title + "' removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Search Movie by Director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Movie Found: Title=" + current.title + ", Director=" + current.director +
                        ", Year=" + current.yearOfRelease + ", Rating=" + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for Director: " + director);
        }
    }

    // Search Movie by Rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Movie Found: Title=" + current.title + ", Director=" + current.director +
                        ", Year=" + current.yearOfRelease + ", Rating=" + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with Rating: " + rating);
        }
    }

    // Display all Movie Records in Forward Order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movie records to display.");
            return;
        }
        Movie current = head;
        System.out.println("Movies in Forward Order:");
        while (current != null) {
            System.out.println("Title=" + current.title + ", Director=" + current.director +
                    ", Year=" + current.yearOfRelease + ", Rating=" + current.rating);
            current = current.next;
        }
    }

    // Display all Movie Records in Reverse Order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records to display.");
            return;
        }
        Movie current = tail;
        System.out.println("Movies in Reverse Order:");
        while (current != null) {
            System.out.println("Title=" + current.title + ", Director=" + current.director +
                    ", Year=" + current.yearOfRelease + ", Rating=" + current.rating);
            current = current.prev;
        }
    }

    // Update Movie Rating by Title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating for '" + title + "' updated to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding Movies
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition(2, "Dunkirk", "Christopher Nolan", 2017, 7.9);

        // Display Movies in Forward Order
        movieList.displayForward();

        // Searching Movies
        movieList.searchByDirector("Christopher Nolan");
        movieList.searchByRating(8.8);

        // Update Movie Rating
        movieList.updateRating("Inception", 9.2);
        movieList.displayForward();

        // Remove Movie by Title
        movieList.removeByTitle("Interstellar");
        movieList.displayForward();

        // Display Movies in Reverse Order
        movieList.displayReverse();
    }
}

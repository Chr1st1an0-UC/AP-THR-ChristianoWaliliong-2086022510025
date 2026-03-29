import java.util.*;

// Base class
class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        if (title.length() > 255) title = title.substring(0, 255);
        if (author.length() > 50) author = author.substring(0, 50);
        if (year <= 1800 || year >= 2026) year = 2000;

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}

// GeneralBook
class GeneralBook extends Book {
    String genre;

    public GeneralBook(String title, String author, int year, String genre) {
        super(title, author, year);

        if (genre.length() > 30) genre = genre.substring(0, 30);
        this.genre = genre;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

// ChildrenBook
class ChildrenBook extends Book {
    int minAge;
    boolean hasVisualisation;

    public ChildrenBook(String title, String author, int year, int minAge, boolean hasVisualisation) {
        super(title, author, year);

        if (minAge <= 3 || minAge >= 12) minAge = 5;
        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisualisation ? "Yes" : "No"));
    }
}

// Main CLI
public class Nomor5 {
    static Scanner sc = new Scanner(System.in);
    static Stack<Book> books = new Stack<>();

    public static void main(String[] args) {

        // preload 5 books
        books.push(new Book("Why Black Moves First", "Wesley So", 2025));
        books.push(new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        books.push(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));
        books.push(new Book("Physics 101", "Albert Newton", 2001));
        books.push(new GeneralBook("Deep Ocean", "James Cameron", 2010, "Science"));

        while (true) {
            System.out.println("\n1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print(">> ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> deleteBook();
                case 4 -> {
                    System.out.println("Exit...");
                    return;
                }
            }
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println("\nBook " + (i + 1));
            books.get(i).getInfo();
        }
    }

    static void addBook() {
        System.out.println("1. Book");
        System.out.println("2. GeneralBook");
        System.out.println("3. ChildrenBook");
        System.out.print("Choose: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        if (type == 1) {
            books.push(new Book(title, author, year));
        } else if (type == 2) {
            sc.nextLine();
            System.out.print("Genre: ");
            String genre = sc.nextLine();
            books.push(new GeneralBook(title, author, year, genre));
        } else if (type == 3) {
            System.out.print("Min Age: ");
            int age = sc.nextInt();

            System.out.print("Has Visualisation (true/false): ");
            boolean vis = sc.nextBoolean();

            books.push(new ChildrenBook(title, author, year, age, vis));
        }

        System.out.println("Book added!");
    }

    static void deleteBook() {
        viewBooks();
        System.out.print("Delete index: ");
        int idx = sc.nextInt();

        if (idx < 1 || idx > books.size()) {
            System.out.println("Invalid index!");
            return;
        }

        books.remove(idx - 1);
        System.out.println("Book deleted!");
    }
}
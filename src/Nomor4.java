class Item {
    String title;
    int releaseYear;
    double price;

    public Item(String title, int releaseYear, double price) {
        // validasi
        if (title.length() > 255) title = title.substring(0, 255);
        if (releaseYear <= 1800 || releaseYear >= 2026) releaseYear = 2000;

        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("releaseYear: " + releaseYear);
        System.out.println("Price: " + price);
    }
}

// DVD
class Dvd extends Item {
    double runtime;

    public Dvd(String title, int releaseYear, double price, double runtime) {
        super(title, releaseYear, price);

        if (runtime >= 720) runtime = 0;
        this.runtime = runtime;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + runtime + " minutes");
        System.out.println();
    }
}

// Magazine
class Magazine extends Item {
    String author;
    int numPages;

    public Magazine(String title, int releaseYear, double price, String author, int numPages) {
        super(title, releaseYear, price);

        if (author.length() > 50) author = author.substring(0, 50);

        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages);
        System.out.println();
    }
}

// Vinyl
class Vinyl extends Item {
    int size;

    public Vinyl(String title, int releaseYear, double price, int size) {
        super(title, releaseYear, price);

        if (size > 12) size = 12;

        this.size = size;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + size);
        System.out.println();
    }
}

// Main
public class Nomor4 {
    public static void main(String[] args) {

        Item d = new Dvd("Baby be Mine", 1982, 50000, 4);
        Item m = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Item v = new Vinyl("Song of The Wind", 1967, 350000, 12);

        d.getDescription();
        m.getDescription();
        v.getDescription();
    }
}
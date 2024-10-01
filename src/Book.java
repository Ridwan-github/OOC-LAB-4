import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Book {
    String title;
    String author;
    String genre;
    int pages;
    LocalDate dateRead;

    public Book(String title, String author, String genre, int pages, String dateRead) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.dateRead = LocalDate.parse(dateRead, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static int getPages(Object o) {
        return ((Book) o).pages;
    }
}


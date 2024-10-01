import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BookList {
    private List<Book> books;

    public BookList(List<Book> books) {
        this.books = books;
    }


    public int totalBooksReadLastYear() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return (int) books.stream().filter(book -> book.dateRead.isAfter(oneYearAgo)).count();
    }


    public Map<Month, Long> booksReadEachMonth() {
        return books.stream()
                .collect(Collectors.groupingBy(book -> book.dateRead.getMonth(), Collectors.counting()));
    }


    public List<Book> top10LongestBooks() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPages).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }


    public String mostReadGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(book -> book.genre, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No genres available");
    }


    public double averageBookLength() {
        return books.stream().mapToInt(Book::getPages).average().orElse(0.0);
    }
}

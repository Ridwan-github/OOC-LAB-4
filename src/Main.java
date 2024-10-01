import org.json.JSONArray;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Atomic Habits", "James Clear", "Self-Help", 320, "2023-02-14"));
        bookList.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 310, "2023-03-01"));


        BookList stats = new BookList(bookList);
        System.out.println("Total books read in the last year: " + stats.totalBooksReadLastYear());
        System.out.println("Books read each month: " + stats.booksReadEachMonth());
        System.out.println("Top 10 longest books: " + stats.top10LongestBooks());
        System.out.println("Most read genre: " + stats.mostReadGenre());
        System.out.println("Average book length: " + stats.averageBookLength());

        try {

            JSONReader jsonReader = new JSONReader();
            JSONArray booksArray = jsonReader.readJSONFile("books.json");
            jsonReader.parseJSON(booksArray);


            XMLReader xmlReader = new XMLReader();
            Document xmlDoc = xmlReader.readXMLFile("books.xml");
            xmlReader.parseXML(xmlDoc);

        } catch (Exception e) {
            System.out.println("Bhul ase bhai :')) ");
        }
    }
}

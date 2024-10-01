import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JSONReader {
    public JSONArray readJSONFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONArray(content);
    }

    public void parseJSON(JSONArray booksArray) {
        for (int i = 0; i < booksArray.length(); i++) {
            JSONObject book = booksArray.getJSONObject(i);
            System.out.println("Title: " + book.getString("title"));
            System.out.println("Author: " + book.getString("author"));
            System.out.println("Genre: " + book.getString("genre"));
            System.out.println("Pages: " + book.getInt("pages"));
            System.out.println("Date Read: " + book.getString("date_read"));
            System.out.println();
        }
    }
}

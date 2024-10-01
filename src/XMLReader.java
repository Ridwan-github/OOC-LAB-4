import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class XMLReader {
    public Document readXMLFile(String filePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(filePath);
    }

    public void parseXML(Document doc) {
        NodeList bookList = doc.getElementsByTagName("book");

        for (int i = 0; i < bookList.getLength(); i++) {
            Element book = (Element) bookList.item(i);
            System.out.println("Title: " + book.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Author: " + book.getElementsByTagName("author").item(0).getTextContent());
            System.out.println("Genre: " + book.getElementsByTagName("genre").item(0).getTextContent());
            System.out.println("Pages: " + book.getElementsByTagName("pages").item(0).getTextContent());
            System.out.println("Date Read: " + book.getElementsByTagName("date_read").item(0).getTextContent());
            System.out.println();
        }
    }
}

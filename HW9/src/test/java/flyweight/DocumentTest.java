package flyweight;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentTest {

    @Test
    public void testSaveAndLoadDocument() {
        Document doc = new Document();
        doc.addCharacter('H', "Arial", "Red", 12);
        doc.addCharacter('i', "Calibri", "Blue", 14);

        String filename = "test_document.txt";
        doc.saveToFile(filename);

        Document loadedDoc = new Document();
        loadedDoc.loadFromFile(filename);

        assertEquals(2, loadedDoc.getCharacters().size());
        assertEquals('H', loadedDoc.getCharacters().get(0).getCharacter());
        assertEquals("Arial", loadedDoc.getCharacters().get(0).getProperties().getFont());

        new File(filename).delete();
    }
}
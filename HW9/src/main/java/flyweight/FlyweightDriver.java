package flyweight;

public class FlyweightDriver {
    public static void main(String[] args) {
        Document document = new Document();

        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 12);
        document.addCharacter('l', "Arial", "Red", 12);
        document.addCharacter('l', "Arial", "Red", 12);
        document.addCharacter('o', "Arial", "Red", 12);

        document.addCharacter('W', "Calibri", "Blue", 14);
        document.addCharacter('o', "Calibri", "Blue", 14);
        document.addCharacter('r', "Calibri", "Blue", 14);
        document.addCharacter('l', "Calibri", "Blue", 14);
        document.addCharacter('d', "Calibri", "Blue", 14);

        document.addCharacter('C', "Verdana", "Black", 16);
        document.addCharacter('S', "Verdana", "Black", 16);

        document.addCharacter('3', "Arial", "Black", 14);
        document.addCharacter('5', "Arial", "Black", 14);
        document.addCharacter('6', "Arial", "Black", 14);
        document.addCharacter('0', "Arial", "Black", 14);

        String filename = "HelloWorldCS3560.txt";

        document.saveToFile(filename);
        Document loadedDocument = new Document();
        loadedDocument.loadFromFile(filename);

        System.out.println("Printing from saved+loaded document:");
        for (Character c : loadedDocument.getCharacters()) {
            System.out.println(c.getCharacter() + " [" +
                    c.getProperties().getFont() + ", " +
                    c.getProperties().getColor() + ", " +
                    c.getProperties().getSize() + "]");
        }

    }
}
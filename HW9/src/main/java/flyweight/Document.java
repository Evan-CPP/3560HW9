package flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, String font, String color, int size) {
        CharacterProperties props = CharacterPropertiesFactory.getProperties(font, color, size);
        characters.add(new Character(c, props));
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character ch : characters) {
                writer.write(ch.getCharacter() + "," +
                        ch.getProperties().getFont() + "," +
                        ch.getProperties().getColor() + "," +
                        ch.getProperties().getSize());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving document: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        characters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    char c = parts[0].charAt(0);
                    String font = parts[1];
                    String color = parts[2];
                    int size = Integer.parseInt(parts[3]);

                    addCharacter(c, font, color, size);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading document: " + e.getMessage());
        }
    }
}
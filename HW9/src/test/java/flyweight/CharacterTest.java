package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    public void testCharacterAndProperties() {
        CharacterProperties props = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        Character testChar = new Character('F', props);

        assertEquals('F', testChar.getCharacter());
        assertEquals("Arial", testChar.getProperties().getFont());
        assertEquals("Red", testChar.getProperties().getColor());
        assertEquals(12, testChar.getProperties().getSize());
    }
}
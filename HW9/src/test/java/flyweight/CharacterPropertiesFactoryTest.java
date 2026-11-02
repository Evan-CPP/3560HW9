package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CharacterPropertiesFactoryTest {

    @Test
    public void testSameInstanceDuplicateProperties() {
        CharacterProperties prop1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties prop2 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);

        assertSame(prop1, prop2);
    }

    @Test
    public void testFactoryProperties() {
        CharacterProperties prop1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties prop2 = CharacterPropertiesFactory.getProperties("Times New Roman", "Blue", 14);

        assertEquals("Arial", prop1.getFont());
        assertEquals("Blue", prop2.getColor());
    }
}
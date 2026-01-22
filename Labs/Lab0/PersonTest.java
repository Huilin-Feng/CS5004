import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testGetFirstName() {
        Person p = new Person("Lynn", "Feng");
        assertEquals("Lynn", p.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Person p = new Person("Lynn", "Feng");
        assertEquals("Feng", p.getLastName());
    }

    @Test
    public void testToString() {
        Person p = new Person("Lynn", "Feng");
        assertEquals("Lynn Feng", p.toString());
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test for Tea class
 * @author Raul Soto
 * @version 0.1.α
 */
class TeaTest {

    // Tea object will revert to this state after each test.
    Tea tea = new Tea("Earl Grey", 12, 2.50, 80);
    Tea defaultTea = new Tea();
    Tea copy = new Tea(tea);

    @Test
    void testGetBrewTemp() {
        assertEquals(80, tea.getBrewTemp());
    }

    @Test
    void testSetBrewTemp() {
        assertFalse(tea.setBrewTemp(-1));
        assertTrue(tea.setBrewTemp(75));
        assertEquals(75, tea.getBrewTemp());
    }

    @Test
    void testSetAll() {
        assertFalse(tea.setAll("Chamomile", -10, 2.00, 170));
        assertFalse(tea.setAll("Chamomile", 10, -2.00, 170));
        assertFalse(tea.setAll("Chamomile", 10, 2.00, -170));
        assertTrue(tea.setAll("Chamomile", 10, 2.00, 170));
        assertEquals("Chamomile", tea.getName());
        assertEquals(10, tea.getOunces());
        assertEquals(2.00, tea.getPrice());
        assertEquals(170, tea.getBrewTemp());
    }


    @Test
    void testEquals() {
        assertEquals(tea, new Tea("Earl Grey", 12, 2.50, 80));
        assertNotEquals(tea, new Tea());
    }

    @Test
    void testToString() {
        assertTrue(tea.toString().contains("Earl Grey"));
    }
}

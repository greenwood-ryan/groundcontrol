import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    
    @Test
    public void testConstructor() {
        Position position = new Position(5, 10);
        assertNotNull(position);
    }
    
    @Test
    public void testEquals_SameCoordinates() {
        Position position1 = new Position(3, 7);
        Position position2 = new Position(3, 7);
        assertEquals(position1, position2);
    }
    
    @Test
    public void testEquals_SameObject() {
        Position position = new Position(1, 2);
        assertEquals(position, position);
    }
    
    @Test
    public void testHashCode_SameCoordinates() {
        Position position1 = new Position(4, 8);
        Position position2 = new Position(4, 8);
        assertEquals(position1.hashCode(), position2.hashCode());
    }
}
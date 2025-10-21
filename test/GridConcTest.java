import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GridConcTest {
    
    @Test
    public void testConstructorAndGetters() {
        GridConc grid = new GridConc(5, 3);
        assertEquals(5, grid.getMaxX());
        assertEquals(3, grid.getMaxY());
    }
    
    @Test
    public void testIsWithinBounds_ValidCoordinates() {
        GridConc grid = new GridConc(10, 8);
        
        assertTrue(grid.isWithinBounds(0, 0));
        assertTrue(grid.isWithinBounds(5, 4));
        assertTrue(grid.isWithinBounds(10, 8));
    }
    
    @Test
    public void testIsWithinBounds_InvalidCoordinates() {
        GridConc grid = new GridConc(10, 8);
        
        assertFalse(grid.isWithinBounds(-1, 0));
        assertFalse(grid.isWithinBounds(0, -1));
        assertFalse(grid.isWithinBounds(11, 8));
        assertFalse(grid.isWithinBounds(10, 9));
    }
}
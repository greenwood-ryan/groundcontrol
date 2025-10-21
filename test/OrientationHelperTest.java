import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrientationHelperTest {
    
    @Test
    public void testTurnLeft() {
        assertEquals('W', OrientationHelper.turnLeft('N'));
        assertEquals('N', OrientationHelper.turnLeft('E'));
        assertEquals('E', OrientationHelper.turnLeft('S'));
        assertEquals('S', OrientationHelper.turnLeft('W'));
    }
    
    @Test
    public void testTurnRight() {
        assertEquals('E', OrientationHelper.turnRight('N'));
        assertEquals('S', OrientationHelper.turnRight('E'));
        assertEquals('W', OrientationHelper.turnRight('S'));
        assertEquals('N', OrientationHelper.turnRight('W'));
    }
    
    @Test
    public void testGetMovementDelta() {
        assertArrayEquals(new int[]{0, 1}, OrientationHelper.getMovementDelta('N'));
        assertArrayEquals(new int[]{1, 0}, OrientationHelper.getMovementDelta('E'));
        assertArrayEquals(new int[]{0, -1}, OrientationHelper.getMovementDelta('S'));
        assertArrayEquals(new int[]{-1, 0}, OrientationHelper.getMovementDelta('W'));
    }
}
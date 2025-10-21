import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Happy path unit tests for RobotStateConc
 */
public class RobotStateConcTest {
    
    @Test
    public void testConstructorSetsInitialState() {
        RobotStateConc robot = new RobotStateConc(1, 2, 'N');
        
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals('N', robot.getOrientation());
        assertFalse(robot.isLost());
    }
    
    @Test
    public void testSetPosition() {
        RobotStateConc robot = new RobotStateConc(0, 0, 'E');
        
        robot.setPosition(3, 4);
        
        assertEquals(3, robot.getX());
        assertEquals(4, robot.getY());
    }
    
    @Test
    public void testSetOrientation() {
        RobotStateConc robot = new RobotStateConc(1, 1, 'N');
        
        robot.setOrientation('S');
        
        assertEquals('S', robot.getOrientation());
    }
    
    @Test
    public void testMarkAsLost() {
        RobotStateConc robot = new RobotStateConc(2, 3, 'W');
        
        robot.markAsLost();
        
        assertTrue(robot.isLost());
    }
    
    @Test
    public void testToStringNormal() {
        RobotStateConc robot = new RobotStateConc(1, 2, 'N');
        
        assertEquals("1 2 N", robot.toString());
    }
    
    @Test
    public void testToStringLost() {
        RobotStateConc robot = new RobotStateConc(3, 4, 'E');
        robot.markAsLost();
        
        assertEquals("3 4 E LOST", robot.toString());
    }
}
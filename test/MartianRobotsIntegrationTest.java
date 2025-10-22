import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the complete Martian Robots system
 * Tests the exact requirements from the brief
 */
public class MartianRobotsIntegrationTest {
    
    /** Tests the exact sample input/output from the problem doc. */
    @Test
    public void testSampleInputFromBrief() {
        // Grid: 5 3 (upper-right coordinates, lower-left is 0,0)
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        
        // Robot 1: 1 1 E, RFRFRFRF
        RobotState robot1 = new RobotStateConc(1, 1, 'E');
        controller.executeInstructions(robot1, "RFRFRFRF");
        assertEquals("1 1 E", robot1.toString());
        
        // Robot 2: 3 2 N, FRRFLLFFRRFLL  
        RobotState robot2 = new RobotStateConc(3, 2, 'N');
        controller.executeInstructions(robot2, "FRRFLLFFRRFLL");
        assertEquals("3 3 N LOST", robot2.toString());
        
        // Robot 3: 0 3 W, LLFFFLFLFL
        RobotState robot3 = new RobotStateConc(0, 3, 'W');
        controller.executeInstructions(robot3, "LLFFFLFLFL");
        assertEquals("2 3 S", robot3.toString());
    }
    
    /** Tests that scent left by lost robots prevents future robots from being lost at the same position. */
    @Test
    public void testScentPreventsSubsequentLoss() {
        GridBoundary grid = new GridConc(2, 2);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        
        // First robot goes off edge and leaves scent
        RobotState robot1 = new RobotStateConc(2, 2, 'N');
        controller.executeInstructions(robot1, "F");
        assertTrue(robot1.isLost());
        assertEquals("2 2 N LOST", robot1.toString());
        
        // Second robot at same position ignores dangerous move
        RobotState robot2 = new RobotStateConc(2, 2, 'N');
        controller.executeInstructions(robot2, "F");
        assertFalse(robot2.isLost());
        assertEquals("2 2 N", robot2.toString());
    }
    
    /** Tests that robots are processed sequentially, each completing before the next begins. */
    @Test
    public void testSequentialProcessing() {
        GridBoundary grid = new GridConc(3, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        
        // Each robot finishes before next begins
        RobotState robot1 = new RobotStateConc(0, 0, 'N');
        controller.executeInstructions(robot1, "FFF");
        assertEquals("0 3 N", robot1.toString());
        
        RobotState robot2 = new RobotStateConc(0, 0, 'E');
        controller.executeInstructions(robot2, "FFF");
        assertEquals("3 0 E", robot2.toString());
    }
    
    /** Tests all three command types: L (left turn), R (right turn), F (forward move). */
    @Test
    public void testAllCommandTypes() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        
        RobotState robot = new RobotStateConc(2, 2, 'N');
        
        // Test L (turn left)
        controller.executeInstructions(robot, "L");
        assertEquals('W', robot.getOrientation());
        
        // Test R (turn right)  
        controller.executeInstructions(robot, "R");
        assertEquals('N', robot.getOrientation());
        
        // Test F (move forward)
        controller.executeInstructions(robot, "F");
        assertEquals(2, robot.getX());
        assertEquals(3, robot.getY());
    }
    
    /** Tests that robots are lost when moving off any edge of the grid. */
    @Test
    public void testGridBoundaries() {
        GridBoundary grid = new GridConc(1, 1);
        
        // Test all edges with fresh ScentTracker for each robot
        RobotState robotNorth = new RobotStateConc(0, 1, 'N');
        new RobotController(grid, new ScentTrackerConc()).executeInstructions(robotNorth, "F");
        assertTrue(robotNorth.isLost());
        
        RobotState robotEast = new RobotStateConc(1, 0, 'E');
        new RobotController(grid, new ScentTrackerConc()).executeInstructions(robotEast, "F");
        assertTrue(robotEast.isLost());
        
        RobotState robotSouth = new RobotStateConc(0, 0, 'S');
        new RobotController(grid, new ScentTrackerConc()).executeInstructions(robotSouth, "F");
        assertTrue(robotSouth.isLost());
        
        RobotState robotWest = new RobotStateConc(0, 0, 'W');
        new RobotController(grid, new ScentTrackerConc()).executeInstructions(robotWest, "F");
        assertTrue(robotWest.isLost());
    }
}
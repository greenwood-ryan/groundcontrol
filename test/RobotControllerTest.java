import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotControllerTest {
    
    @Test
    public void testTurnLeft() {
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        RobotState robot = new RobotStateConc(1, 1, 'N');
        
        controller.executeInstructions(robot, "L");
        
        assertEquals('W', robot.getOrientation());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }
    
    @Test
    public void testTurnRight() {
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        RobotState robot = new RobotStateConc(1, 1, 'N');
        
        controller.executeInstructions(robot, "R");
        
        assertEquals('E', robot.getOrientation());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }
    
    @Test
    public void testMoveForward() {
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        RobotState robot = new RobotStateConc(1, 1, 'N');
        
        controller.executeInstructions(robot, "F");
        
        assertEquals('N', robot.getOrientation());
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
    }
    
    /**
     * Tests that the robot can execute a sequence of multiple instructions.
     * Robot moves in a square pattern and returns to starting position and orientation.
     */
    @Test
    public void testMultipleInstructions() {
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        RobotState robot = new RobotStateConc(1, 1, 'E');
        
        controller.executeInstructions(robot, "RFRFRFRF");
        
        assertEquals('E', robot.getOrientation());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }
    
    /**
     * Tests that invalid instructions are ignored during execution.
     * Robot executes L (left turn), ignores X (invalid), then executes R (right turn).
     */
    @Test
    public void testInvalidInstruction() {
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        RobotState robot = new RobotStateConc(1, 1, 'N');
        
        controller.executeInstructions(robot, "LXR");
        
        assertEquals('N', robot.getOrientation());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }
}
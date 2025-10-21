import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveForwardCommandTest {
    
    @Test
    public void testMoveForwardNorth() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(2, 2, 'N');
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(2, state.getX());
        assertEquals(3, state.getY());
        assertFalse(state.isLost());
    }
    
    @Test
    public void testMoveForwardEast() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(2, 2, 'E');
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(3, state.getX());
        assertEquals(2, state.getY());
        assertFalse(state.isLost());
    }
    
    @Test
    public void testMoveForwardSouth() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(2, 2, 'S');
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(2, state.getX());
        assertEquals(1, state.getY());
        assertFalse(state.isLost());
    }
    
    @Test
    public void testMoveForwardWest() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(2, 2, 'W');
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(1, state.getX());
        assertEquals(2, state.getY());
        assertFalse(state.isLost());
    }
    
    @Test
    public void testMoveForwardWithinBounds() {
        GridBoundary grid = new GridConc(3, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(0, 0, 'N');
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(0, state.getX());
        assertEquals(1, state.getY());
        assertFalse(state.isLost());
    }
    
    @Test
    public void testDoesNotMoveWhenAlreadyLost() {
        GridBoundary grid = new GridConc(5, 5);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotState state = new RobotStateConc(2, 2, 'N');
        state.markAsLost();
        MoveForwardCommand command = new MoveForwardCommand(grid, scentTracker);
        
        command.execute(state);
        
        assertEquals(2, state.getX());
        assertEquals(2, state.getY());
        assertTrue(state.isLost());
    }
}
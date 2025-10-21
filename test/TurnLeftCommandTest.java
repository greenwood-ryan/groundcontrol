import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnLeftCommandTest {
    
    @Test
    public void testTurnLeftFromNorth() {
        RobotState state = new RobotStateConc(1, 1, 'N');
        TurnLeftCommand command = new TurnLeftCommand();
        
        command.execute(state);
        
        assertEquals('W', state.getOrientation());
    }
    
    @Test
    public void testTurnLeftFromEast() {
        RobotState state = new RobotStateConc(1, 1, 'E');
        TurnLeftCommand command = new TurnLeftCommand();
        
        command.execute(state);
        
        assertEquals('N', state.getOrientation());
    }
    
    @Test
    public void testTurnLeftFromSouth() {
        RobotState state = new RobotStateConc(1, 1, 'S');
        TurnLeftCommand command = new TurnLeftCommand();
        
        command.execute(state);
        
        assertEquals('E', state.getOrientation());
    }
    
    @Test
    public void testTurnLeftFromWest() {
        RobotState state = new RobotStateConc(1, 1, 'W');
        TurnLeftCommand command = new TurnLeftCommand();
        
        command.execute(state);
        
        assertEquals('S', state.getOrientation());
    }
}
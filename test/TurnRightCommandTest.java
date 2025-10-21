import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnRightCommandTest {
    
    @Test
    public void testTurnRightFromNorth() {
        RobotState state = new RobotStateConc(1, 1, 'N');
        TurnRightCommand command = new TurnRightCommand();
        
        command.execute(state);
        
        assertEquals('E', state.getOrientation());
    }
    
    @Test
    public void testTurnRightFromEast() {
        RobotState state = new RobotStateConc(1, 1, 'E');
        TurnRightCommand command = new TurnRightCommand();
        
        command.execute(state);
        
        assertEquals('S', state.getOrientation());
    }
    
    @Test
    public void testTurnRightFromSouth() {
        RobotState state = new RobotStateConc(1, 1, 'S');
        TurnRightCommand command = new TurnRightCommand();
        
        command.execute(state);
        
        assertEquals('W', state.getOrientation());
    }
    
    @Test
    public void testTurnRightFromWest() {
        RobotState state = new RobotStateConc(1, 1, 'W');
        TurnRightCommand command = new TurnRightCommand();
        
        command.execute(state);
        
        assertEquals('N', state.getOrientation());
    }
}
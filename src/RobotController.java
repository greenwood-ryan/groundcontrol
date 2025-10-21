import java.util.HashMap;
import java.util.Map;

/**
 * Controller that executes robot instructions using the Command pattern.
 * Maps instruction characters to command objects and executes them on robot state.
 */
public class RobotController {
    private final GridBoundary grid;
    private final ScentTracker scentTracker;
    private final Map<Character, Command> commands;
    
    /**
     * Creates a robot controller with grid boundaries and scent tracking.
     * Initializes command mappings for L (left), R (right), and F (forward).
     */
    public RobotController(GridBoundary grid, ScentTracker scentTracker) {
        this.grid = grid;
        this.scentTracker = scentTracker;
        this.commands = new HashMap<>();
        
        commands.put('L', new TurnLeftCommand());
        commands.put('R', new TurnRightCommand());
        commands.put('F', new MoveForwardCommand(grid, scentTracker));
    }
    
    /**
     * Executes a sequence of instructions on the robot.
     * Invalid instructions are ignored.
     */
    public void executeInstructions(RobotState robot, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            Command command = commands.get(instruction);
            if (command != null) {
                command.execute(robot);
            }
        }
    }
}
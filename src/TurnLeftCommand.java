/**
 * Command to turn the robot 90 degrees to the left.
 */
public class TurnLeftCommand implements Command {
    
    /**
     * Executes a left turn by modifying the injected robot state using the
     * OrientationHelper utility class.
     * 
     * @param state The robot's current state injected by the caller.
     *              Contains orientation that will be modified by this command.
     */
    @Override
    public void execute(RobotState state) {
        state.setOrientation(OrientationHelper.turnLeft(state.getOrientation()));
    }
}
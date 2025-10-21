/**
 * Command to move the robot forward one position.
 */
public class MoveForwardCommand implements Command {
    private final GridBoundary grid;
    private final ScentTracker scentTracker;
    
    public MoveForwardCommand(GridBoundary grid, ScentTracker scentTracker) {
        this.grid = grid;
        this.scentTracker = scentTracker;
    }

    /**
     * Executes a move forward by modifying the injected robot state using the
     * OrientationHelper utility class.
     * Contributes to the territory covered record including setting the robot's
     * new position and flagging a location as out of bounds if it is not within
     * the grid boundaries.
     *
     * @param state The robot's current state injected by the caller.
     *              Contains orientation that will be modified by this command.
     */
    @Override
    public void execute(RobotState state) {
        if (state.isLost()) return;
        
        int[] delta = OrientationHelper.getMovementDelta(state.getOrientation());
        int newX = state.getX() + delta[0];
        int newY = state.getY() + delta[1];
        
        if (!grid.isWithinBounds(newX, newY)) {
            if (!scentTracker.hasScent(state.getX(), state.getY())) {
                scentTracker.addScent(state.getX(), state.getY());
                state.markAsLost();
            }
        } else {
            state.setPosition(newX, newY);
        }
    }
}
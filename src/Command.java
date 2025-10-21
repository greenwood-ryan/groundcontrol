/**
 * Command interface
 * We'll use this to implement the movement commands for robot steering
 */
public interface Command {
    void execute(RobotState state);
}
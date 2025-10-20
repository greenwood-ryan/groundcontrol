/**
 * Command interface - allows extension without modification (OCP)
 * Clients depend on abstraction, not concrete implementation (DIP)
 */
public interface Command {
    void execute(RobotState state);
}
/**
 * Abstraction for robot state
 */
public interface RobotState {
    int getX();
    int getY();
    char getOrientation();
    boolean isLost();
    
    void setPosition(int x, int y);
    void setOrientation(char orientation);
    void markAsLost();
}
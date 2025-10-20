/**
 * Concrete implementation of RobotState
 */
public class RobotStateConc implements RobotState {
    private int x;
    private int y;
    private char orientation;
    private boolean lost;
    
    public RobotStateConc(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.lost = false;
    }
    
    @Override
    public int getX() { return x; }
    
    @Override
    public int getY() { return y; }
    
    @Override
    public char getOrientation() { return orientation; }
    
    @Override
    public boolean isLost() { return lost; }
    
    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
    
    @Override
    public void markAsLost() {
        this.lost = true;
    }
    
    @Override
    public String toString() {
        String result = x + " " + y + " " + orientation;
        if (lost) {
            result += " LOST";
        }
        return result;
    }
}
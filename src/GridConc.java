/**
 * Concrete implementation of GridBoundary
 * Define the exploration area for the robot
 */
public class GridConc implements GridBoundary {
    private final int maxX;
    private final int maxY;
    
    public GridConc(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    @Override
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
    
    @Override
    public int getMaxX() { return maxX; }
    
    @Override
    public int getMaxY() { return maxY; }
}
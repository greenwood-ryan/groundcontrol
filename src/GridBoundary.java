/**
 * Abstraction for grid boundary checking
 * Have to know how far is allowable
 */
public interface GridBoundary {
    /** Check if coordinates are within valid grid bounds */
    boolean isWithinBounds(int x, int y);
    
    /** Maximum x size of the grid*/
    int getMaxX();
    
    /** Maximum y size of the grid */
    int getMaxY();
}
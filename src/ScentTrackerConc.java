import java.util.HashSet;
import java.util.Set;

/**
 * Concrete implementation of ScentTracker
 */
public class ScentTrackerConc implements ScentTracker {
    private final Set<Position> scents;
    
    public ScentTrackerConc() {
        this.scents = new HashSet<>();
    }
    
    @Override
    public boolean hasScent(int x, int y) {
        return scents.contains(new Position(x, y));
    }
    
    @Override
    public void addScent(int x, int y) {
        scents.add(new Position(x, y));
    }
}
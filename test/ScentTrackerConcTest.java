import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic happy path unit tests for ScentTrackerConc
 */
public class ScentTrackerConcTest {
    
    @Test
    public void testInitiallyNoScents() {
        ScentTrackerConc tracker = new ScentTrackerConc();
        
        assertFalse(tracker.hasScent(0, 0));
        assertFalse(tracker.hasScent(1, 1));
        assertFalse(tracker.hasScent(5, 3));
    }
    
    @Test
    public void testAddScentAndDetect() {
        ScentTrackerConc tracker = new ScentTrackerConc();
        
        tracker.addScent(2, 3);
        
        assertTrue(tracker.hasScent(2, 3));
        assertFalse(tracker.hasScent(2, 4));
        assertFalse(tracker.hasScent(3, 3));
    }
    
    @Test
    public void testMultipleScents() {
        ScentTrackerConc tracker = new ScentTrackerConc();
        
        tracker.addScent(1, 1);
        tracker.addScent(5, 2);
        tracker.addScent(0, 4);
        
        assertTrue(tracker.hasScent(1, 1));
        assertTrue(tracker.hasScent(5, 2));
        assertTrue(tracker.hasScent(0, 4));
        assertFalse(tracker.hasScent(1, 2));
    }
    
    @Test
    public void testDuplicateScents() {
        ScentTrackerConc tracker = new ScentTrackerConc();
        
        tracker.addScent(3, 3);
        tracker.addScent(3, 3);
        
        assertTrue(tracker.hasScent(3, 3));
    }
}
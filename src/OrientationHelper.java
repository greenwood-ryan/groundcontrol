import java.util.Map;
import java.util.HashMap;

/**
 * Helper class for orientation calculations
 * N=0, E=1, S=2, W=3.  To calculate the new orientation, add 1 to the index,
 * or subtract 1 from the index.
 */
public class OrientationHelper {
    private static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};
    private static final Map<Character, Integer> DIRECTION_INDEX = new HashMap<>();
    
    static {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            DIRECTION_INDEX.put(DIRECTIONS[i], i);
        }
    }
    
    /**
     * Turns 90 degrees to the left from your current direction.
     * Example: If facing North, you'll now face West.
     * Uses (index + 3) % 4 which is equivalent to subtracting 1 by adding 3 and taking modulus 4
     * We use this approach because the directions form a circular array
     * - they wrap around in a cycle.  We'd have a problem at the boundaries otherwise
     * N(0) → E(1) → S(2) → W(3) → N(0) → E(1) → ...
     * @param currentOrientation The direction you're currently facing (N, E, S, or W)
     * @return The new direction after turning left
     */
    public static char turnLeft(char currentOrientation) {
        int index = getDirectionIndex(currentOrientation);
        return DIRECTIONS[(index + 3) % 4]; // -1 mod 4
    }
    
    /**
     * Turns 90 degrees to the right from your current direction.
     * Example: If facing North, you'll now face East.
     * Uses (index + 1) % 4 which is equivalent to adding 1
     * We use modulus because the directions form a circular array
     * - they wrap around in a cycle. We'd have a problem at the boundaries otherwise
     * N(0) → E(1) → S(2) → W(3) → N(0) → E(1) → ...
     * @param currentOrientation The direction you're currently facing (N, E, S, or W)
     * @return The new direction after turning right
     */
    public static char turnRight(char currentOrientation) {
        int index = getDirectionIndex(currentOrientation);
        return DIRECTIONS[(index + 1) % 4];
    }
    
    /**
     * Gets how much to move on a grid when going one step in a direction.
     * Returns x and y changes: [x_change, y_change]
     * North moves up, East moves right, South moves down, West moves left.
     * @param orientation The direction to move (N, E, S, or W)
     * @return Array with x and y movement values [x, y]
     */
    public static int[] getMovementDelta(char orientation) {
        switch (orientation) {
            case 'N': return new int[]{0, 1};
            case 'E': return new int[]{1, 0};
            case 'S': return new int[]{0, -1};
            case 'W': return new int[]{-1, 0};
            default: return new int[]{0, 0};
        }
    }
    
    /**
     * Finds the position number for a direction letter.
     * N=0, E=1, S=2, W=3. Returns 0 if direction is not recognized.
     * @param orientation The direction letter to look up
     * @return The position number of that direction
     */
    private static int getDirectionIndex(char orientation) {
        return DIRECTION_INDEX.getOrDefault(orientation, 0);
    }
}
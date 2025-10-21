import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Two positions are equal if they have the same x and y coordinates
     */
    @Override
    public boolean equals(Object o) {
        //exact object
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //same position
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    
    /**
     * A unique hash code for this position based on its x and y coordinates.
     * To be used as a key in the HashSet in combination with the equals method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
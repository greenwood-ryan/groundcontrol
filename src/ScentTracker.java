/**
 * Abstraction for scent management
 */
public interface ScentTracker {
    boolean hasScent(int x, int y);
    void addScent(int x, int y);
}
package dotify.core;

/**
 * Represents a single cell in a grid.
 * A cell is defined as a square of a certain size.
 * A cell also may contain exactly 4 child cells.
 */
public interface DotifyCell {
    int getId();
    float getCenterX();
    float getCenterY();
    int getSize();
    int getColor();
    DotifyCell[] getChildCells(); // oder getChilds() nennen?
    // boolean hasChildCells(); optional?
}

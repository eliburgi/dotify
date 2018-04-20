package dotify.core;

import java.util.List;

public interface DotifyGrid {
    /**
     * Gets the width of the grid.
     * Width is defined as: width = numOfCells * cellSize
     * Note that the grid´s w
     * @return
     */
    int getWidth();
    int getHeight();
    ShapeType getShapeType();
    void setShapeType(ShapeType shape);
    List<DotifyCell> getActiveCells();
    List<DotifyCell> getPopableCells();
    int getTotalPopCount();
    int getPopsLeftCount();
    void pop(DotifyCell cell);
    void pop(DotifyCell... cells);
    void popAll();
    void reset(); // Oder void mergeAll() ?
}

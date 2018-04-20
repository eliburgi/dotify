package dotify.core.grid;

import dotify.core.DotifyShape;

import java.util.List;

public interface DotifyGrid {
    int getWidth();

    int getHeight();

    DotifyShape getShapeType();

    void setShapeType(DotifyShape shape);

    List<DotifyCell> getActiveCells();

    List<DotifyCell> getPopableCells();

    int getTotalPopCount();

    int getPopsLeftCount();

    void pop(DotifyCell cell);

    void pop(DotifyCell... cells);

    void popAll();

    void reset(); // Oder void mergeAll() ?
}

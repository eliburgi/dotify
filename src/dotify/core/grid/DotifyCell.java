package dotify.core.grid;

public interface DotifyCell {
    int getId();

    float getCenterX();

    float getCenterY();

    int getSize();

    int getColor();

    DotifyCell[] getChildCells(); // oder getChilds() nennen?
    // boolean hasChildCells(); optional?
}

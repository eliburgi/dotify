package dotify.core;

public interface DotifySketch {
    void start();
    void pause();
    void resume();
    void update(float dt);
    void draw(/*TODO Graphics */);

    void setPopStrategy();
    void setRenderer();
    void setGrid();
    void setLooping();
}

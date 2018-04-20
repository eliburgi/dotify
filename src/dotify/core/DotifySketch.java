package dotify.core;

public class DotifySketch {
    private boolean isRunning = false;

    public void start() {
        isRunning = true;
        // Reset grid
    }

    public void pause() {
        isRunning = false;
    }

    public void resume() {
        isRunning = true;
    }

    public void update(float dt) {
        if(!isRunning) return;

        // Calculate how many pops should be made this frame.

        // Get all popables from the grid.

        // Calculate random indices of cells that should be popped.

        // Pop all of these cells.

        // Add all popped cells to the animation list (fifo).
    }

    public void draw(/*TODO Graphics */) {
        // Render pending animations.

        // Render all active cells that were not already rendered by an animation.
    }

    public void setPopStrategy() {

    }

    /*
    public void setRenderer();

    public void setGrid();

    public void setLooping();*/
}

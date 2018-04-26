package dotify.core;

import com.sun.istack.internal.NotNull;
import dotify.core.grid.DotifyCell;
import dotify.core.grid.DotifyGrid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Transform;

public class DotifySketch {
    private final DotifyGrid grid;
    private boolean isRunning = false;

    public DotifySketch(@NotNull DotifyGrid grid) {
        this.grid = grid;
    }

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
        if (!isRunning) return;

        // Calculate how many pops should be made this frame.

        // Get all popables from the grid.

        // Calculate random indices of cells that should be popped.

        // Pop all of these cells.

        // Update animations.

        // Add all popped cells to the animation list (fifo).
    }

    public void draw(GraphicsContext g, Transform transform) {
        // Render pending animations.

        // Render all active cells that were not already rendered by an animation.

        // OR: Call the renderer that was set, who manages animations, etc.
    }

    public void setPopStrategy() {

    }

    /*
    public void setRenderer();

    public void addPopListener();

    public void setGrid();

    public void setLooping();

    private void pop()*/

    public interface PopListener {
        void onPop(DotifyGrid grid, DotifyCell popped);
    }
}

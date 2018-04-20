package dotify.core;

import com.sun.istack.internal.NotNull;
import dotify.core.grid.DotifyGrid;
import javafx.scene.image.Image;

public final class Dotify {
    private Dotify() {
    }

    public static DotifyGrid parseImage(@NotNull Image img, @NotNull ImageParsingOptions options) {
        /* @TODO: @Zoltan please implement this ;) */
        return null;
    }

    public static class ImageParsingOptions {
        public enum SquareStrategy {FIT_INSIDE, EXTEND_OUTSIDE}

        final int samplingSize;
        final DotifyShape shape;
        final SquareStrategy squareStrategy;

        public ImageParsingOptions(int samplingSize,
                                   @NotNull DotifyShape shape,
                                   @NotNull SquareStrategy squareStrategy) {
            this.samplingSize = samplingSize;
            this.shape = shape;
            this.squareStrategy = squareStrategy;
        }
    }
}

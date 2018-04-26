package dotify.play;

import com.sun.istack.internal.NotNull;
import dotify.control.DotifyAudioButton;
import dotify.core.DotifySketch;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class DotifyPlayScreen {
    private enum ViewState {INSTRUCTIONS, PLAYING, LOADING, ERROR}

    @FXML
    private Node headerBar;
    @FXML
    private Node headerLogo;
    @FXML
    private Node content;
    @FXML
    private Node instructionBox;
    @FXML
    private Button letsGoButton;
    @FXML
    private Canvas canvas;
    @FXML
    private Node audioControlBox;
    @FXML
    private DotifyAudioButton audioButton;

    private DotifySketch sketch;
    private AnimationTimer gameLoopTimer;

    public void initialize() {
        showViewStateUi(ViewState.INSTRUCTIONS);
    }

    private void update(float dt) {
        // update audio analysis
        // update frequency line heights
        // update dotify sketch
    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        int dotsPerW = 100;
        int dotsPerH = (int) (dotsPerW * canvas.getHeight() / canvas.getWidth());
        double dotWidth = canvas.getWidth() / dotsPerW;
        g.setFill(Color.LIGHTGREY);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setFill(Color.ALICEBLUE);
        for (int y = 0; y < dotsPerH; y++) {
            for (int x = 0; x < dotsPerW; x++) {
                g.fillOval(x * dotWidth, y * dotWidth, dotWidth, dotWidth);
            }
        }
    }

    // TODO pass settings like image, audio, etc.
    private void startGame() {
        // show game ui
        showViewStateUi(ViewState.PLAYING);

        // init audio controls
        // add click listener to audio button
        // set audio button state (STOP, PLAY, MICRO)

        // init canvas

        // init sketch

        // init camera
        // get sketch aspect ratio and set canvas to that size such that it fits into content area
        // when screen size changes -> recalculate canvas size using aspectRatio

        // start game loop
        if (gameLoopTimer == null) {
            gameLoopTimer = new AnimationTimer() {
                private long last;

                @Override
                public void handle(long now) {
                    float dt = (now - last) / 1_000_000;
                    update(dt);
                    draw();
                    last = now;
                }
            };
        }
        gameLoopTimer.start();
    }

    private void showViewStateUi(@NotNull ViewState state) {
        switch (state) {
            case PLAYING:
                showInstructionUi(false);
                showPlayUi(true);
                enableAudioControl(true);
                break;
            case INSTRUCTIONS:
                showPlayUi(false);
                showInstructionUi(true);
                enableAudioControl(false);
                break;
            case LOADING:
                break;
            case ERROR:
                break;
        }
    }

    private void showInstructionUi(boolean show) {
        instructionBox.setDisable(!show);
        instructionBox.setVisible(show);
        letsGoButton.setOnAction(show ? e -> showDotifyDialog() : null);
    }

    private void showDotifyDialog() {
        // TODO show dialog and get resulting settings
        // show parsing image ui
        // if there is an error parsing: show error ui
        // when parsing finished start a new game with settings
        startGame();
    }

    private void showPlayUi(boolean show) {
        canvas.setVisible(show);
    }

    private void enableAudioControl(boolean enabled) {
        // always show audio controls but when disabled with less opacity
        audioControlBox.setVisible(true);
        audioControlBox.setDisable(!enabled);
        audioControlBox.setOpacity(enabled ? 1.0 : 0.3);
        // TODO add click listener
    }
}

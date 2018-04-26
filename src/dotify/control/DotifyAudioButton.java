package dotify.control;

import com.sun.istack.internal.NotNull;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;

import java.io.IOException;

public class DotifyAudioButton extends StackPane {
    public enum State {PLAY, STOP, REPLAY}

    private State state;
    private double progress;
    private Node stopIcon;
    private Node playIcon;
    private Node replayIcon;
    private Arc progressBar;

    public DotifyAudioButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("audio_button.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        stopIcon = lookup("#stopIcon");
        playIcon = lookup("#playIcon");
        replayIcon = lookup("#replayIcon");
        progressBar = (Arc) lookup("#progressBar");

        widthProperty().addListener((o, oldVal, newVal) -> progressBar.setCenterX(newVal.doubleValue() / 2));
        heightProperty().addListener((o, oldVal, newVal) -> progressBar.setCenterY(newVal.doubleValue() / 2));

        setOnMouseClicked(e -> toggle());
        setAlignment(Pos.CENTER);
        setWidth(60);
        setHeight(60);
        setMaxSize(60, 60);
        setState(State.PLAY);
        setProgress(0.0);
    }

    private void toggle() {
        if (state == State.PLAY) {
            setState(State.STOP);
        } else if (state == State.STOP) {
            setState(State.PLAY);
        }
        double newProgress = progress + 0.05;
        if (newProgress > 1.05) newProgress = 0.0;
        setProgress(newProgress);
    }

    public void setProgress(double progress) {
        if (progress > 1.0) progress = 1.0;
        else if (progress < 0.0) progress = 0.0;
        this.progress = progress;
        if(this.progress == 1.0) setState(State.REPLAY);
        updateProgressUi();
    }

    public void setState(@NotNull State state) {
        this.state = state;
        updateButtonUi();
    }

    private void updateProgressUi() {
        progressBar.setLength(-progress * 360.0);
    }

    private void updateButtonUi() {
        playIcon.setVisible(false);
        stopIcon.setVisible(false);
        replayIcon.setVisible(false);
        if (state == State.PLAY) {
            playIcon.setVisible(true);
        } else if (state == State.STOP) {
            stopIcon.setVisible(true);
        } else {
            replayIcon.setVisible(true);
        }
    }
}

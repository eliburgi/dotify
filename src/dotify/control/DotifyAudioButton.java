package dotify.control;

import com.sun.istack.internal.NotNull;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;

import java.io.IOException;

public class DotifyAudioButton extends StackPane {
    public enum State {PLAYING, STOPPED, REPLAY}

    private State state;
    private double progress;
    private Node stopIcon;
    private Node playIcon;
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
        progressBar = (Arc) lookup("#progressBar");

        setOnMouseClicked(e -> toggle());
        setAlignment(Pos.CENTER);
        setWidth(60);
        setHeight(60);
        setMaxSize(60, 60);
        setState(State.STOPPED);
        setProgress(0.0);
    }

    private void toggle() {
        if (state == State.PLAYING) {
            setState(State.STOPPED);
        } else if (state == State.STOPPED) {
            setState(State.PLAYING);
        }
        double newProgress = progress + 0.1;
        if(newProgress > 1.0) newProgress = 0.0;
        setProgress(newProgress);
    }

    public void setProgress(double progress) {
        if(progress < 0.0 || progress > 1.0) return;
        this.progress = progress;
        updateProgressUi();
    }

    public void setState(@NotNull State state) {
        this.state = state;
        updateButtonUi();
    }

    private void updateProgressUi() {
        progressBar.setLength(progress * 360.0);
    }

    private void updateButtonUi() {
        if (state == State.PLAYING) {
            playIcon.setVisible(true);
            stopIcon.setVisible(false);
        } else if (state == State.STOPPED) {
            playIcon.setVisible(false);
            stopIcon.setVisible(true);
        }
    }
}

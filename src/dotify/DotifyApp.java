package dotify;

import dotify.control.DotifyAudioButton;
import dotify.core.Dotify;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class DotifyApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("play/play_screen.fxml"));
        primaryStage.setTitle("Dotify");
        primaryStage.setScene(new Scene(root));
        Pane content = (Pane) root.lookup("#content");
        Canvas canvas = (Canvas) root.lookup("#sketchCanvas");
        canvas.getGraphicsContext2D().setFill(Color.ORANGE);
        DotifyAudioButton btn = (DotifyAudioButton) root.lookup("#audioBtn");
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }.start();

        canvas.widthProperty().bind(content.widthProperty());
        canvas.heightProperty().bind(content.heightProperty());
    }


    public static void main(String[] args) {
        launch(args);
    }
}

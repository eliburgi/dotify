package dotify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DotifyApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("play/play_screen.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Dotify");
        primaryStage.setMinWidth(360);      //change from 1360 to 360
        primaryStage.setMinHeight(768);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

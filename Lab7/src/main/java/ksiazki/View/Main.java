package ksiazki.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ksiazki.Model.JDBC;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Luckiest+Guy");

        primaryStage.setTitle("Hello World");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void init() {
    }
}

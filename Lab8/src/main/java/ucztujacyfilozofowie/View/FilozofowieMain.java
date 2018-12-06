package ucztujacyfilozofowie.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ucztujacyfilozofowie.Model.Kelner;

public class FilozofowieMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Problem ucztujących filozofów");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

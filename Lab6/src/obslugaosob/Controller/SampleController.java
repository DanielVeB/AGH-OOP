package obslugaosob.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.LinkedList;


public class SampleController {
    @FXML
    private Button dodaj,wyswietl;



    @FXML
    public void dodajpracownika(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/obslugaosob/View/dodajpracownika.fxml"));
            Parent root1 = (Parent) loader.load();
            DodajPracownika dodajPracownika= loader.getController();

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    public void wyswietlpracownikow(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/obslugaosob/View/wyswietl.fxml"));
            Parent root1 = (Parent) loader.load();
            WyswietlPracownikow wyswietlPracownikow= loader.getController();
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

package obslugaosob.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import obslugaosob.Model.Kadra;
import obslugaosob.Model.Pracownik;
import obslugaosob.Model.WyswietlDodanegoPracownika;

public class DodajPracownika  {

    private Kadra kadra=new Kadra();

    @FXML
    private Button potwierdz;

    @FXML
    private TextField imie,nazwisko,wynagrodzenie;

    @FXML
    public void potwierdzenie(ActionEvent event){
        kadra.zarejestrujlistenera(new WyswietlDodanegoPracownika());
        kadra.zarejestrujlistenera(new WyswietlPracownikow());
        kadra.dodaj(new Pracownik(imie.getText(),nazwisko.getText(),Double.parseDouble(wynagrodzenie.getText())));

        Stage stage = (Stage)potwierdz.getScene().getWindow();
        stage.close();
    }
}

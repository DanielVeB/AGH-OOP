package obslugaosob.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import obslugaosob.Model.DodanoPracownika;
import obslugaosob.Model.Pracownik;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class WyswietlPracownikow implements DodanoPracownika,Initializable {
    @FXML
    private TableView tabela;

    @FXML
    private Label liczba;

    private static LinkedList<Pracownik>pracowniks=new LinkedList<>();

    @Override
    public void dodajpracownika(Pracownik pracownik) {
        this.pracowniks.add(pracownik);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tabela.setEditable(true);
        liczba.setText("Liczba pracownikow: "+this.pracowniks.size());

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(180);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("imie"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(180);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("nazwisko"));

        TableColumn wynagrodzenieCol = new TableColumn("Wynagrodzenie");
        wynagrodzenieCol.setMinWidth(180);
        wynagrodzenieCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Double>("wynagrodzenie"));

        ObservableList<Pracownik> data = FXCollections.observableArrayList();
        for(Pracownik pracownik:pracowniks){
            data.add(pracownik);
        }
        tabela.setItems(data);
        tabela.getColumns().addAll(firstNameCol, lastNameCol, wynagrodzenieCol);
    }
}

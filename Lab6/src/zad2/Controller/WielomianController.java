package zad2.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;

import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import zad2.Model.Wielomian;

import java.net.URL;
import java.util.*;

public class WielomianController implements Initializable {

    @FXML
    private Button ok;

    @FXML
    private Label zakres,wiadomosc;
    @FXML
    private TextField wielomian,_od,_do,krok;

    @FXML
    private LineChart<Number,Number>linechart;

    private Wielomian w;
    @FXML
    private void oki(ActionEvent event) {
        try {
            double k1=Double.parseDouble(_od.getText());
            double k2=Double.parseDouble(_do.getText());
            double k3=Double.parseDouble(krok.getText());

            w = new Wielomian(wielomian.getText());
            Map<Double,Double>mapa=new HashMap<>();
            mapa=w.getFunkcja(k1,k2,k3);
            SortedSet<Double> keys = new TreeSet<>(mapa.keySet());

            XYChart.Series <Number,Number> series= new XYChart.Series<Number,Number>();
            for (Double key : keys) {
                Double value = mapa.get(key);
                series.getData().add(new XYChart.Data<Number, Number>(key,value));
            }

            linechart.getData().add(series);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            wiadomosc.setText("Blad");
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

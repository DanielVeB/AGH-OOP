package ucztujacyfilozofowie.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import ucztujacyfilozofowie.Model.Filozof;
import ucztujacyfilozofowie.Model.Kelner;


import java.net.URL;
import java.util.*;

public class FilozofieController implements Initializable,Runnable {
    @FXML
    private TextArea area;
    @FXML
    private List<Label> labelList;
    @FXML
    private List<ImageView>forks;
    @FXML
    private List<Circle>plates;
    @FXML
    private List<ImageView>forks_of_philosophers;
    private Filozof[]filozofowie=new Filozof[5];
    private Thread[]threads=new Thread[5];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Kelner.przygotujwidelce(forks,area);
        int count = 0 ;
        for (Label label : labelList) {
            int idleft=count;
            int idright=count-1;
            if(idright<0)idright=4;
            filozofowie[count]=new Filozof(count,label,forks_of_philosophers.get(count*2),forks_of_philosophers.get(count*2+1));
            threads[count]=new Thread(filozofowie[count],"Filozof"+count);
            threads[count].start();
            count++;

        }

    }


    @Override
    public void run() {
        System.out.println("123");
    }
}



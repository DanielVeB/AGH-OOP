package ksiazki.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ksiazki.Model.JDBC;

public class AddBook {
    @FXML
    private TextField isbn,author,title,year;
    @FXML
    private Button addbutton;
    @FXML
    private Label info;


    @FXML
    public void add(ActionEvent event){
        if(isbn.getText().isEmpty() ||author.getText().isEmpty() ||title.getText().isEmpty() ||year.getText().isEmpty() ){
            info.setText("Fill all fields !!");
        }else{
            info.setText("");
            try {
                JDBC.addBook(isbn.getText(),author.getText(),title.getText(),Integer.parseInt(year.getText()));
                info.setText("Book added");
            }catch (Exception ex){
                info.setText(ex.getMessage());
            }

        }

    }
}

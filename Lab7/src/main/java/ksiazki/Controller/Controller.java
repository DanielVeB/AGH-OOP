package ksiazki.Controller;

import com.mysql.jdbc.ResultSetImpl;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import ksiazki.Model.JDBC;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private AnchorPane mainPane,connectPane;
    @FXML
    private Button connectbutton,confirmchoice,newBook;
    @FXML
    private Label warning,info;

    @FXML
    private TextField url,user,name;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> columns;

    @FXML TableView books;

    int i=3;

    @FXML
    public void addBook(ActionEvent event){}


    @FXML
    public void connect_with_database(ActionEvent event){

        try {
            JDBC.connect(url.getText(), user.getText(), password.getText());
            connectPane.setVisible(false);
            mainPane.setVisible(true);
        }catch (Exception ex){
            i--;
            if(i==0){
                Platform.exit();
                System.exit(0);
            }
            warning.setText("Nie udalo sie nawiazac polaczenia,pozostalo prob: "+i);

        }
    }
    @FXML
    public void confirm(ActionEvent event){
        info.setVisible(false);
        books.setVisible(false);
        ResultSet rs=null;
        if(columns.getValue().equals("isbn  ")){
            rs=JDBC.returnbyisbn(name.getText());
        }else if(columns.getValue().equals("author  ")){
            rs=JDBC.returnbyAuthor(name.getText());
        }
        try {
            if(!rs.next()){
                info.setVisible(true);
                info.setText("Brak takiej ksiązki");
            }else{
                showtable(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private void showtable(ResultSet rs) {
        try {
            books.setVisible(true);
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            books.getColumns().clear();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setMinWidth(200);
                col.setSortable(false);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                books.getColumns().addAll(col);

            }
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));

                }
                System.out.println(row);
                data.add(row);
            }
            books.setItems(data);

        }catch (SQLException ex){

        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columns.getItems().addAll("isbn  ","author  ");
        url.setText("jdbc:mysql://mysql.agh.edu.pl/");
        password.setText("N5shFdrcVWPFfQfC");
        books.setVisible(false);

    }
}

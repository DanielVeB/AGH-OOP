package ucztujacyfilozofowie.Model;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javax.xml.soap.Text;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kelner {

    private static List<Widelec>widelce;
    private static Queue<Filozof>listaoczekujaca;
    @FXML
    private static List<ImageView>forks;
    @FXML
    private static TextArea pole;
    private static String[]listafilozofow=new String[]{
      "Sokrates","Platon","Pitagoras","Epikur","Arystoteles"
    };

    public static void przygotujwidelce(List<ImageView> f, TextArea area){
        pole=area;
        forks=f;
        widelce=new LinkedList<>();
        listaoczekujaca=new ArrayDeque<>();
        for(int i=0;i<5;i++){
            widelce.add(new Widelec(i));
        }
    }
    public static void wyczyscwidelce(Filozof f){
        int idfilozofa=f.getId();
        int lewywidelec=f.getId();
        int prawywidelec=f.getId()-1;
        if(prawywidelec<0)prawywidelec=4;
        widelce.get(lewywidelec).odloz();
        widelce.get(prawywidelec).odloz();
        int i=0;
        for(Widelec w:widelce){
            if(w.isCzyjestuzywany()){
                forks.get(i).setVisible(false);
            }else{
                forks.get(i).setVisible(true);

            }i++;
        }

    }
    public static void podajwidelce(Filozof f) throws InterruptedException {
        if(f.getId()==listaoczekujaca.peek().getId()){
            int lewywidelec=f.getId();
            int prawywidelec=f.getId()-1;
            if (prawywidelec<0)prawywidelec=4;
            if(!widelce.get(lewywidelec).isCzyjestuzywany() && !widelce.get(prawywidelec).isCzyjestuzywany()){
                listaoczekujaca.remove();
                widelce.get(lewywidelec).uzyj();
                widelce.get(prawywidelec).uzyj();
                int i=0;
                for(Widelec w:widelce){
                    if(w.isCzyjestuzywany()){
                        forks.get(i).setVisible(false);
                    }else{
                        forks.get(i).setVisible(true);

                    }i++;
                }
                f.jedz();
            }
        }

    }
    public static void dodajdokolejki(Filozof f){
        listaoczekujaca.add(f);
    }
    public static void sluchajfilozofa(Filozof f) throws InterruptedException {
        dodajdokolejki(f);
        pole.setText("Kolejka do jedzenia:\n");
        for(Filozof ff:listaoczekujaca){
            System.out.print(ff.getId()+" ");
            String t=pole.getText();
            pole.setText(t+"\n"+listafilozofow[ff.getId()]);
        }
        System.out.println();


    }



}

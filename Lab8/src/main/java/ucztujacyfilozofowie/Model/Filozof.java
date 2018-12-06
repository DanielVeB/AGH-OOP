package ucztujacyfilozofowie.Model;


import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Filozof implements Runnable {
    private int id;
    private Label label;
    private boolean czyprosilowidelce=false;
    private ImageView leftfork=new ImageView();
    private ImageView rightfork=new ImageView();
    public int getId() {
        return id;
    }

    public Filozof(int id, Label label,ImageView left,ImageView right){
        this.label=label;
        this.id=id;
        leftfork=left;
        rightfork=right;
        leftfork.setVisible(false);
        rightfork.setVisible(false);
    }
    private void mysl() throws InterruptedException{
        Platform.runLater(new Runnable() {
            @Override public void run() {
                label.setText("rozmyslam");
                leftfork.setVisible(false);
                rightfork.setVisible(false);
            }
        });
        Thread.sleep(((int) (Math.random() * 5000)));
    }

    public void jedz() throws InterruptedException{
        Platform.runLater(new Runnable() {
            @Override public void run() {
                label.setText("jem");
                leftfork.setVisible(true);
                rightfork.setVisible(true);
            }
        });

        Thread.sleep(((int) (Math.random() * 10000)));
        Kelner.wyczyscwidelce(this);
        czyprosilowidelce=false;
    }

    private void spytaj_o_widelce() throws InterruptedException{
        Platform.runLater(new Runnable() {
            @Override public void run() {
                label.setText("Czy moge widelce?");
            }
        });
        Kelner.sluchajfilozofa(this);
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    @Override
    public void run() {
        while (true){
            try {
                mysl();
                if(!czyprosilowidelce){
                    spytaj_o_widelce();
                    czyprosilowidelce=true;
                }else {
                    Kelner.podajwidelce(this);
                }
            }catch (InterruptedException ex){
                System.out.println("1");
            }
        }
    }

}

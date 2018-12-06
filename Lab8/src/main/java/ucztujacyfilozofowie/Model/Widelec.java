package ucztujacyfilozofowie.Model;

public class Widelec {
    private int id;
    private boolean czyjestuzywany;

    public Widelec(int id){
        this.id=id;
        this.czyjestuzywany=false;
    }
    public void uzyj(){
        czyjestuzywany=true;
    }
    public void odloz(){
        czyjestuzywany=false;
    }

    public boolean isCzyjestuzywany() {
        return czyjestuzywany;
    }
}

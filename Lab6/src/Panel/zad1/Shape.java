package Panel.zad1;

import java.awt.*;

public abstract class Shape{
    public String name;
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public Shape(){
    }

    public abstract void draw(Graphics graphics);

}
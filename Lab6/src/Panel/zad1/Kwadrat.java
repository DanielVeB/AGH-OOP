package Panel.zad1;

import java.awt.*;

public class Kwadrat extends Shape{
    private int bok;

    public Kwadrat(int bok) {
        this.bok=bok;
     }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(32,12,244));
        graphics.drawRect(0,0,bok,bok);
    }

}

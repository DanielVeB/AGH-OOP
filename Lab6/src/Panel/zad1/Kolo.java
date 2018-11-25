package Panel.zad1;

import java.awt.*;

public class Kolo extends Shape{
    private int promien;
    public Kolo(int promien){
        this.promien=promien;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(132,152,44));
        graphics.drawOval(0,0,promien,promien);
    }
}

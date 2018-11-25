package Panel.zad1;

import java.awt.*;

class Prostokat extends Shape {
    private int a,b;
    public Prostokat(int a,int b){
        this.a=a;
        this.b=b;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(0,0,a,b);
    }

}

package Panel;

import Panel.zad1.*;
import Panel.zad1.ListofShapes;
import Panel.zad1.Shape;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private ListofShapes listofShapes;
    private Graphics graphics;

    public MyPanel() {
        listofShapes=new ListofShapes();
        Shape kwadrat=new Kwadrat(215);
        Shape kolo=new Kolo(513);
        listofShapes.add(kwadrat);
        listofShapes.add(kolo);
    }
    public void paint(Graphics graphics){
        for(Shape shape:ListofShapes.getShapes()){
            shape.draw(graphics);
        }
    }


}

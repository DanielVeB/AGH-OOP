package Panel.zad1;

import java.util.LinkedList;

public class ListofShapes {
    private static LinkedList<Shape>shapes=new LinkedList<>();
    public ListofShapes(){
    }
    public void add(Shape shape){
        shapes.add(shape);
    }

    public static LinkedList<Shape> getShapes() {
        return shapes;
    }
}

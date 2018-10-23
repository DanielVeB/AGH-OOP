package pl.edu.agh.student.danielkurosz.shapes;

public abstract class Shape{
    public String name;
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public Shape(String name){
        this.name=name;
    }

    public abstract void draw();

    public static void main(String[] args) {
        Shape a=new Kwadrat("kwadrat");
        a.draw();
    }
}
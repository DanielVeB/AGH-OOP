package pl.edu.agh.student.danielkurosz.zad1;

public abstract class Shape{
    public String name;
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public Shape(String name){
        this.name=name;
    }

    public abstract void draw();

}
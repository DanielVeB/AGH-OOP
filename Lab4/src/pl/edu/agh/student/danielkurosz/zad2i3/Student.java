package pl.edu.agh.student.danielkurosz.zad2i3;

public class Student extends Pracownik{

    @Override
    public double wynagrodzenieNetto() {
        return wynagrodzenieBrutto/0.9;
    }
}

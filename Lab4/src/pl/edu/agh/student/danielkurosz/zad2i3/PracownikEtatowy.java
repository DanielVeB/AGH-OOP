package pl.edu.agh.student.danielkurosz.zad2i3;

public class PracownikEtatowy extends Pracownik {


    @Override
    public double wynagrodzenieNetto() {
        return wynagrodzenieBrutto/0.71;
    }
}

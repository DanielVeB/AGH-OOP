package pl.edu.agh.student.danielkurosz.zad2i3;

public abstract class Pracownik {
    protected double wynagrodzenieBrutto;
    protected Pesel pesel;

    public Pesel getPesel() {
        return pesel;
    }
    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }

    public void setWynagrodzenieBrutto(double d){
        wynagrodzenieBrutto=d;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public abstract double wynagrodzenieNetto();

}

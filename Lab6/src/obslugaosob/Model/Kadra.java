package obslugaosob.Model;

import obslugaosob.Controller.DodajPracownika;

import java.util.ArrayList;
import java.util.List;

public class Kadra {
    private List<Pracownik> pracownicy = new ArrayList<>();
    private List <DodanoPracownika> listeners = new ArrayList <> ();

    public void dodaj (Pracownik a) {
        pracownicy.add(a);
        zglos(a);
    }
    public void zarejestrujlistenera (DodanoPracownika listener) {
        listeners.add(listener);
    }
    public void wyrejestrujlistenera (DodanoPracownika listener) {
        listeners.remove(listener);
    }
    protected void zglos (Pracownik a) {
        listeners.forEach(listener -> listener.dodajpracownika(a));
    }
}

package obslugaosob.Model;

import obslugaosob.Controller.DodajPracownika;

import java.util.ArrayList;
import java.util.List;

public  class Kadra {
    private static List<Pracownik> pracownicy = new ArrayList<>();
    private static List <DodanoPracownika> listeners = new ArrayList <> ();

    public static void dodaj (Pracownik a) {
        pracownicy.add(a);
        zglosdodanie(a);
    }
    public static void usun(Pracownik a){
        pracownicy.remove(a);
        zglosusuniecie(a);
    }

    public static void zarejestrujlistenera (DodanoPracownika listener) {
        listeners.add(listener);
    }
    public static void wyrejestrujlistenera (DodanoPracownika listener) {
        listeners.remove(listener);
    }
    protected static void zglosdodanie (Pracownik a) {
        listeners.forEach(listener -> listener.dodajpracownika(a));
    }
    protected static void zglosusuniecie (Pracownik a) {
        listeners.forEach(listener -> listener.usunpracownika(a));
    }
}

package obslugaosob.Model;

public class WyswietlDodanegoPracownika implements DodanoPracownika {
    @Override
    public void dodajpracownika(Pracownik pracownik) {
        System.out.println(pracownik.getImie()+" "+pracownik.getNazwisko()+ " "+pracownik.getWynagrodzenie());
    }

    @Override
    public void usunpracownika(Pracownik pracownik) {
        System.out.println("Usunieto: "+pracownik.getNazwisko());
    }
}

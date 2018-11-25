package obslugaosob.Model;

public class WyswietlDodanegoPracownika implements DodanoPracownika {
    @Override
    public void dodajpracownika(Pracownik pracownik) {
        System.out.println(pracownik.getImie()+" "+pracownik.getNazwisko()+ " "+pracownik.getWynagrodzenie());
    }
}

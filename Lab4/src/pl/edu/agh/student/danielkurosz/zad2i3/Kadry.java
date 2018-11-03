package pl.edu.agh.student.danielkurosz.zad2i3;

import java.util.*;


public class Kadry implements Comparator<Pracownik>{
    private LinkedList<Pracownik>kadra=new LinkedList<>();

    private void dodajpracownika(){
        Scanner scanner=new Scanner(System.in);

        System.out.printf("1. Student\n2. Pracownik etatowy");
        int a=scanner.nextInt();
        Pracownik pracownik=null;
        switch (a){
            case 1:
                pracownik=new Student();
                break;
            case 2:
                pracownik=new PracownikEtatowy();
                break;
                default:
                    System.out.printf("Blad");
        }
        scanner.nextLine();
        System.out.printf("Numer pesel: ");
        String numerpesel=scanner.nextLine();
        Pesel pesel=null;
        try {
            pesel = new Pesel(numerpesel);
        }catch (OwnException ex){
            System.out.print(ex.getMessage());
            return;
        }
        if(checkpesel(pesel.returnnumber())==-1) {
            pracownik.setPesel(pesel);
            System.out.print("Wynagrodzenie brutto: ");
            double wynagrodzenie=scanner.nextDouble();
            pracownik.setWynagrodzenieBrutto(wynagrodzenie);
            kadra.push(pracownik);
        }else{
            System.out.printf("Jest juz pracownik o takim numerze pesel");
        }
    }
    private int  checkpesel(String  pesel){
        int i=0;
        for (Pracownik pracownik: kadra){
            if(Objects.equals(pracownik.getPesel().returnnumber(), pesel))return i;
            ++i;
        }
        return -1;
    }
    private void usunpracownika(){
        Scanner scanner=new Scanner(System.in);
        String numer=scanner.nextLine();
        int index=checkpesel(numer);
        if(index!=-1){
            kadra.remove(index);
        }else System.out.printf("Brak takiego pracownika");
    }
    private void znajdzpracownika(){
        Scanner scanner=new Scanner(System.in);
        String numer=scanner.nextLine();
        int index=checkpesel(numer);
        if(index!=-1){
            int choice=0;
            while (choice!=4) {
                System.out.printf("1. Pobierz wynagrodzenie brutto" +
                        "\n2. Zmiana wynagrodzenia brutto " +
                        "\n3. Pobranie wynagrodzenia netto" +
                        "\n4. Zakoncz");
                System.out.printf("\nNumer: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(kadra.get(index).wynagrodzenieBrutto);
                        break;
                    case 2:
                        double wynagrodzenie=scanner.nextDouble();
                        kadra.get(index).setWynagrodzenieBrutto(wynagrodzenie);
                        break;
                    case 3:
                        System.out.println(kadra.get(index).wynagrodzenieNetto());
                        break;
                    case 4:
                        break;
                        default:
                }
            }
        }else{
            System.out.printf("Nie znaleziono pracownika\n");
        }
    }


    @Override
    public int compare(Pracownik o1, Pracownik o2) {
        return (int)(o1.getWynagrodzenieBrutto()-o2.getWynagrodzenieBrutto());
    }
    public void sort(){
        Collections.sort(kadra,new Kadry());
        for(Pracownik pracownik:kadra){
            System.out.println(pracownik.getPesel().returnnumber()+" "+pracownik.getWynagrodzenieBrutto());
        }
    }


    public static void main(String[] args) {
    Kadry kadry=new Kadry();
    Scanner scanner=new Scanner(System.in);
    int a=0;
    while (a!=5){
        System.out.printf("1. Dodaj pracownika" +
                "\n2. Usuniecie pracownika" +
                "\n3. Wyszukanie pracownika" +
                "\n4. Sortowanie" +
                "\n5. Koniec \n");
        System.out.printf("Podaj numer:  ");
        a=scanner.nextInt();
        switch (a){
            case 1:
                kadry.dodajpracownika();
                break;
            case 2:
                kadry.usunpracownika();
                break;
            case 3:
                kadry.znajdzpracownika();
                break;
            case 4:
                kadry.sort();
                break;
            case 5:
                break;
            default:
                System.out.printf("Brak opcji");

        }
    }

    }


}

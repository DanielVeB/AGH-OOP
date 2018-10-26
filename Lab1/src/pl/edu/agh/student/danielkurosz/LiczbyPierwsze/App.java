package pl.edu.agh.student.danielkurosz.LiczbyPierwsze;

import pl.edu.agh.student.danielkurosz.javaIn.*;

public class App {
    public static void main(String[] args) {
        System.out.printf("Wpisz liczbe");
        int liczba=Integer.parseInt(JIn.getString());
        if(LiczbyPierwsze.primaritytest(liczba)) System.out.printf("Liczba pierwsza");
        else System.out.printf("To nie jest liczba pierwsza");
    }
}

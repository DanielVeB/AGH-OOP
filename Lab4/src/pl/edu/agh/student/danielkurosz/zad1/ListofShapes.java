package pl.edu.agh.student.danielkurosz.zad1;

import java.util.LinkedList;
import java.util.Scanner;

public class ListofShapes {
    private static LinkedList<Shape>shapes=new LinkedList<>();


    public static void main(String[] args) {
        int a=0;
        Scanner scanner=new Scanner(System.in);
        while (a!=3){
            System.out.printf("1. Dodaj element" +
                    "\n2. Wyswietl elementy" +
                    "\n3. Koniec");
            a=scanner.nextInt();
            switch (a){
                case 1:
                    Shape shape=null;
                    System.out.printf("1.Kwadrat" +
                            "\n2.Prostokat" +
                            "\n3.Kolo\n");
                    int k=0;
                    while (k==0){
                        int choice=scanner.nextInt();
                        switch (choice){
                            case 1:
                                k=1;
                                shape=new Kwadrat("kwadrat");
                                break;
                            case 2:
                                k=1;
                                shape=new Prostokat("prostokat");
                                break;
                            case 3:
                                k=1;
                                shape=new Kolo("kolo");
                                break;
                                default:
                                    System.out.printf("Niepoprawna wartosc. Wpisz numer ponownie.\n");
                        }
                    }
                    shapes.add(shape);
                    break;
                case 2:
                   for (Shape s:shapes){
                       s.draw();
                       System.out.printf("");
                   }
                    break;
                case 3:
                    System.out.printf("Koniec programu");
                    break;
                default:
                    System.out.printf("Niepoprawny numer\n");
            }
        }
    }
}

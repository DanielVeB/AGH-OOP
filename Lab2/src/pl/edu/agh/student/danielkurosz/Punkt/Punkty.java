package pl.edu.agh.student.danielkurosz.Punkt;

import java.util.LinkedList;
import java.util.Scanner;

public class Punkty {


    public static void main(String []args){
        LinkedList<Punkt3D>punkty=new LinkedList<Punkt3D>();
        Scanner scanner=new Scanner(System.in);
        int a=0;
        while(a!=4){
            System.out.printf("1.Wczytaj punkt 3d\n" +
                    "2.Wyswietl wszystkie punkty\n" +
                    "3.Oblicz odleglosci\n" +
                    "4.Koniec\n");
            a=scanner.nextInt();
            switch (a){
                case 1:
                    System.out.printf("wspolrzedna x: ");
                    double x=scanner.nextDouble();
                    System.out.printf("wspolrzedna y: ");
                    double y=scanner.nextDouble();
                    System.out.printf("wspolrzedna z: ");
                    double z=scanner.nextDouble();
                    Punkt3D punkt3D=new Punkt3D(x,y,z);
                    punkty.push(punkt3D);
                    break;
                case 2:
                    for(Punkt3D punkt: punkty){
                        System.out.println(punkt.getX()+", "+punkt.getY()+", "+punkt.getZ());
                    }
                    break;
                case 3:
                    for (Punkt3D punkt: punkty){
                        System.out.println(punkt.distance());
                    }
                    break;
            }
        }

    }

}

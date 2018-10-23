package pl.edu.agh.student.danielkurosz.zad5;

import java.io.*;
import java.util.Scanner;

public class Cryptographer {

    static void cryptfile(String text,String crypttext,Algorithm algorithm)  {

        Scanner sc2 = null;
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        PrintWriter out=null;
        try {
            fileWriter=new FileWriter(crypttext,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter writer = new PrintWriter(crypttext);
            writer.print("");
            writer.close();
            out = new PrintWriter(bufferedWriter);
            sc2 = new Scanner(new File(text));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                String k=algorithm.crypt(s);
                out.print(k+" ");
            }out.println();

        }
        out.close();

    }




    static void decryptfile(String crypttext ,String descrypttext,Algorithm algorithm){
        Scanner sc2 = null;
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        PrintWriter out=null;
        try {
            fileWriter=new FileWriter(descrypttext,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter writer = new PrintWriter(descrypttext);
            writer.print("");
            writer.close();
            out = new PrintWriter(bufferedWriter);
            sc2 = new Scanner(new File(crypttext));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                String k=algorithm.decrypt(s);
                out.print(k+" ");
            }out.println();

        }
        out.close();

    }


    public static void main(String[] args) {

        Algorithm algorithm=null;

        System.out.printf("Wybierz algorytm szyfrowania" +
                "\n1. ROT11" +
                "\n2. Plansza Polibiusza");
        int choice=0;
        while (choice!=1 && choice !=2 ){
            Scanner scanner=new Scanner(System.in);
            System.out.print("\n Wpisz numer: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    algorithm=new ROT11();
                    break;
                case 2:
                    algorithm=new Polibiusz();
                    break;
                default:
                    System.out.printf("Wpisz 1 albo 2 ");

            }
        }
        System.out.printf("1. Szyfrowanie\n2. Deszyfrowanie \nPodaj numer: ");
        choice=0;
        while (choice!=1 && choice !=2 ){
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    cryptfile(args[0],args[1],algorithm);
                    break;
                case 2:
                    decryptfile(args[0],args[1],algorithm);
                    break;
                default:
                    System.out.printf("Wpisz 1 albo 2 ");

            }
        }



    }
}


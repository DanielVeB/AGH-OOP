package pl.edu.agh.student.danielkurosz;

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
        Algorithm a=new Polibiusz();
        cryptfile(args[0], args[1], a);
        decryptfile(args[1],"text",a);

    }
}


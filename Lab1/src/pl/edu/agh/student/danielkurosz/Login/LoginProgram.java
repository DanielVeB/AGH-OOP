package pl.edu.agh.student.danielkurosz.Login;

import java.io.*;
/**
 *
 * @author DanielKurosz
 */
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            //TODO prosba o wpisanie hasła i loginu
            System.out.printf("Wpisz login:  ");
            String login = bfr.readLine();
            System.out.printf("Wpisz haslo:  ");
            String haslo = bfr.readLine();

         /*TODO : sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         *przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         *wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
            if(log.check(login,haslo)){
                System.out.printf("OK");
            }else{
                System.out.printf("Zly login lub/i haslo");
            }

        }catch(IOException e){e.printStackTrace();}

    }
}
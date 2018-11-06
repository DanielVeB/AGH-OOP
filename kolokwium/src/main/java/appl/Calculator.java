package appl;

import excp.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Calculator implements Saveable{

    private double result;

    @Override
    public void SavetoFile(double x, String filename)throws FileNotFoundException {
        PrintWriter writer=new PrintWriter(filename);
        writer.println(result);
        writer.close();
    }
    public Calculator(){
        result=0;
    }
    public Calculator Add(double x){
        result+=x;
        return this;
    }
    public Calculator Substract(double x){
        result-=x;
        return this;
    }
    public Calculator Multiply(double x){
        result*=x;
        return this;
    }
    public Calculator Divide(double x){
        result/=x;
        return this;
    }
    public Calculator Factorial() throws TooBigNumberException{
        int d=(int)Math.floor(result);
        if(d>10)throw new TooBigNumberException(d);
        else{
            int wynik=1;
            for(int i=1;i<=d;++i){
                wynik*=i;
            }
            result=(double)wynik;
        }
        return this;

    }
    public double getResult(){
        return result;
    }



    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        try {
            calculator.Add(10).Substract(1).Divide(3).Multiply(2).Factorial().SavetoFile(calculator.result,"resultat.txt");
        }catch (TooBigNumberException | FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

}

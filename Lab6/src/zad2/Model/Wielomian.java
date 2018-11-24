package zad2.Model;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Wielomian {
    private ListMultimap<Integer,Integer> wartosci;
    private Map<Double,Double> funkcja;

public Wielomian(String wyrazenie)throws Exception{
    wartosci= ArrayListMultimap.create();
    wyrazenie=wyrazenie.replaceAll("-","+-");
    System.out.println(wyrazenie);
    String[] parts = wyrazenie.split("\\+");
    for(String s:parts){

        if(s.charAt(s.length()-1)=='x'){
            s=s.replaceAll("x","x^1");
        }
        if(!s.contains("x")){
            s+="x^0";
        }
        System.out.println(s);
        if(s.matches("-?[0-9]*x\\^[0-9]+")){
            String[]numbers=s.split("x\\^");
            if(Objects.equals(numbers[0], "-"))numbers[0]="-1";
            if(Objects.equals(numbers[0], ""))numbers[0]="1";
            int ile=Integer.parseInt(numbers[0]);
            int stopien=Integer.parseInt(numbers[1]);

            if(wartosci.containsKey(stopien)){
                int actual=wartosci.get(stopien).get(0);
                actual+=ile;
                wartosci.put(stopien,actual);
            }else
            wartosci.put(stopien,ile);
        }
        else{
            System.out.println("li");
            throw new Exception("Zly format");}
    }
}

    public Map<Double, Double> getFunkcja(double _od,double _do,double krok) {
    funkcja=new HashMap<>();
        for(double x=_od;x<_do;x+=krok){
            double y=obliczy(x);
            funkcja.put(x,y);
        }
        return funkcja;
    }

    private double obliczy(double wartosc){
    double w=0.;
    for (Integer key : wartosci.keySet()) {
        w+=Math.pow(wartosc,key)*wartosci.get(key).get(wartosci.get(key).size()-1);
    }
    return w;
}

}

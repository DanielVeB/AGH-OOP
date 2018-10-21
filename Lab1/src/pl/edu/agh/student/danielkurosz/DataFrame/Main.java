package pl.edu.agh.student.danielkurosz.DataFrame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataFrame dataFrame=new DataFrame(new String[]{"kol1","kol2","kol3"},new String[]{"int","String","boolean"});
        System.out.println("Rozmiar dataframe przed dodaniem rekordow: "+dataFrame.size());
        dataFrame.add(1,"31.12",true);
        dataFrame.add(2,"asdasda",false);
        dataFrame.add(3,"1231a",2);
        dataFrame.add(4,"09000,,,,1",false);
        dataFrame.add(5,"12",false);

        System.out.println("Rozmiar dataframe: "+dataFrame.size());
        ArrayList<?> arrayList=new ArrayList<>();
        try {
            arrayList = dataFrame.get("kol2");
            for(Object a:arrayList){
                System.out.println(a);
            }
        }catch (OwnError ex){
        }
        SparseDataFrame sparseDataFrame=null;
        try {
            sparseDataFrame=new SparseDataFrame(new String[]{"kol1","kol2"},new String[]{"int","int"},"0");
        }catch (NumberFormatException ex){
            System.out.println("Niepoprawny argument w konstruktorze");
        }catch (WrongNames ex){
            System.out.println(ex.getMessage());
        }
        sparseDataFrame.add(1,1);
        sparseDataFrame.add(0,2);
        sparseDataFrame.add(3,0);
        sparseDataFrame.add(0,0);
        sparseDataFrame.add(0,0);
        sparseDataFrame.add(5,0);
        sparseDataFrame.add(0,6);
        sparseDataFrame.add(7,7);

        sparseDataFrame.test();
    }
}

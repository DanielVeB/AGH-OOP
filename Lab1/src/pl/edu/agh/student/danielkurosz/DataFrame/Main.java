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
        dataFrame.display();

        ArrayList<?> arrayList=new ArrayList<>();
        try {
            arrayList = dataFrame.get("kol3");
            System.out.println("Kol3: ");
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
        sparseDataFrame.add(5,0);
        sparseDataFrame.add(0,6);
        sparseDataFrame.add(7,7);

        DataFrame todensedataframe=sparseDataFrame.toDense();
        System.out.println("Wyswietlanie dataframe po operacji toDense");
        todensedataframe.display();


        DataFrame dataFrame1=new DataFrame(new String[]{"kol1","kol2","kol3"},new String[]{"int","int","int"});
        dataFrame1.add(1,0,0);
        dataFrame1.add(0,2,7);
        dataFrame1.add(0,0,0);
        dataFrame1.add(4,0,4);
        dataFrame1.add(0,0,5);
        System.out.println("Wyswietlenie dataframe:\n ");
        dataFrame1.display();

        try {
            SparseDataFrame sparseDataFrame1=new SparseDataFrame(dataFrame1,"0");
            System.out.println("Wyswietlenie sparsedataframe: \n");
            sparseDataFrame1.display();
        }catch (WrongNames ex){
            System.out.println( ex.getMessage());
        }catch (OwnError ex){

        }
    }
}

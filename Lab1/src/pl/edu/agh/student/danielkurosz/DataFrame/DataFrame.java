package pl.edu.agh.student.danielkurosz.DataFrame;

import java.util.ArrayList;
import java.util.Objects;

public class DataFrame {

    private ArrayList[] table;
    private String[]name_of_columns;
    private String[]data_types;

    private DataFrame(String[] _name_of_columns, String[] _data_types){
        name_of_columns=_name_of_columns;
        data_types=_data_types;
        table=new ArrayList[_name_of_columns.length];
        for(int i=0;i<_name_of_columns.length;++i) {
            try {
                table[i]=new ArrayList<Objects>();
            }catch ( ArrayIndexOutOfBoundsException ex){
                System.out.print(ex.getMessage());
            }
        }
    }
    private DataFrame(DataFrame df){
        name_of_columns=df.name_of_columns;
        data_types=df.data_types;
        table=new ArrayList[name_of_columns.length];
        System.arraycopy(df.table, 0, table, 0, table.length);
    }
    private void add(Object ... args){
        if(args.length!=table.length){
            System.out.printf("blad");
        }else{
            for(int i=0;i<table.length;++i){
                if(data_types[i].equals("int")){
                    int x= (Integer)args[i];
                    table[i].add(x);
                }else if(data_types[i].equals("char")){
                    char c=(Character)args[i];
                    table[i].add(c);
                }else if(data_types[i].equals("double")){
                    double c=(Double) args[i];
                    table[i].add(c);
                }else if(data_types[i].equals("boolean")){
                    boolean c=(Boolean) args[i];
                    System.out.println(c);
                    table[i].add(c);
                }else if(data_types[i].equals("float")){
                    float c=(Float) args[i];
                    table[i].add(c);
                }
                table[i].add(args[i]);
            }
        }
    }
    private int size(){
        return table[0].size();
    }

    private ArrayList<Object> get(String colname)throws OwnError{
        int i=-1;
        int k=i;
        for(String name:name_of_columns){
            k+=1;
            if(name.matches(colname)){
                i=k;
            }
        }if(i==-1)throw new OwnError("Brak takiej kolumny ");
        ArrayList<Object> arrayList=new ArrayList<>();
        arrayList.addAll(table[i]);
        return arrayList;
    }
    private DataFrame iloc(int i)throws OwnError{
        if(i>=table[0].size())throw new OwnError("Brak takiego wiersza");
        DataFrame newdataframe=new DataFrame(name_of_columns,data_types);
        for(int k=0;k<table.length;++k){
            newdataframe.table[k].add(table[k].get(i));
        }
        return newdataframe;
    }
    private DataFrame iloc(int from,int to)throws OwnError{
        if(from>to)throw new OwnError("Pierwszy argument musi byc mniejszy");
        else if(to>table[0].size())throw new OwnError("Nie ma takich wierszy");
        DataFrame newdataframe=new DataFrame(name_of_columns,data_types);
        for(int i=from;i<=to;++i) {
            for (int k = 0; k < table.length; ++k) {
                newdataframe.table[k].add(table[k].get(i));
            }
        }
        return newdataframe;
    }

    public static void main(String[] args) {
        DataFrame dataFrame=new DataFrame(new String[]{"kol1","kol2","kol3"},new String[]{"int","String","boolean"});
        System.out.println(dataFrame.size());
        dataFrame.add(1,"31.12",true);
        dataFrame.add(2,"asdasda",false);
        dataFrame.add(3,"1231a","3.4");
        dataFrame.add(4,"09000,,,,1","01..1");
        dataFrame.add(5,"12","1");

        System.out.println(dataFrame.size());
        try {
            ArrayList<Object> arrayList=dataFrame.get("kol2");
            for(Object o:arrayList){
                //System.out.println(o.toString());
            }
            DataFrame df=dataFrame.iloc(1,4);
            ArrayList<Object> arrayList1=df.get("kol2");
            for(Object o:arrayList1){
                //System.out.println(o.toString());
            }
        }catch (OwnError ex){
        }
    }

}
class OwnError extends Exception{
    OwnError(String message){
        System.out.println(message);
    }
}

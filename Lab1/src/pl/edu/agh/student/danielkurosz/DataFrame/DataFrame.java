package pl.edu.agh.student.danielkurosz.DataFrame;

import java.util.ArrayList;
import java.util.Objects;

public class DataFrame {

    protected ArrayList[] table;
    protected String[]name_of_columns;
    protected String[]data_types;

    public DataFrame(String[] _name_of_columns, String[] _data_types){
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
    public DataFrame(DataFrame df){
        name_of_columns=df.name_of_columns;
        data_types=df.data_types;
        table=new ArrayList[name_of_columns.length];
        System.arraycopy(df.table, 0, table, 0, table.length);
    }
    public void add(Object ... args){
        if(args.length!=table.length){
            System.out.printf("blad");
        }else{
            for(int i=0;i<table.length;++i){
                if(data_types[i].equals("int")){
                    try{
                    int x= (Integer)args[i];
                    table[i].add(x);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else if(data_types[i].equals("char")){
                    try{
                    char c=(Character)args[i];
                    table[i].add(c);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else if(data_types[i].equals("double")){
                    try{
                        double d=(Double) args[i];
                        table[i].add(d);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else if(data_types[i].equals("boolean")){
                    try{
                        boolean b=(Boolean) args[i];
                        table[i].add(b);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else if(data_types[i].equals("float")){
                    try{
                        float f=(Float) args[i];
                        table[i].add(f);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else if(data_types[i].equals("long")){
                    try{
                        long l=(Long) args[i];
                        table[i].add(l);
                    } catch (ClassCastException ex){
                        System.out.println(ex.getMessage());
                        if(i>0)delete(i);
                        break;
                    }
                }else
                    table[i].add(args[i]);
            }
        }
    }
    private void delete(int k){
        for(int i=k-1;i>=0;i--){
            table[i].remove(table[i].size()-1);
        }
    }
    public int size(){
        return table[0].size();
    }

    public ArrayList<Object> get(String colname)throws OwnError{
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
    public DataFrame iloc(int i)throws OwnError{
        if(i>=table[0].size())throw new OwnError("Brak takiego wiersza");
        DataFrame newdataframe=new DataFrame(name_of_columns,data_types);
        for(int k=0;k<table.length;++k){
            newdataframe.table[k].add(table[k].get(i));
        }
        return newdataframe;
    }
    public DataFrame iloc(int from,int to)throws OwnError{
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



}
class OwnError extends Exception{
    OwnError(String message){
        System.out.println(message);
    }
}

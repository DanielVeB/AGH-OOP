package pl.edu.agh.student.danielkurosz.DataFrame;

import java.util.ArrayList;
import java.util.Objects;

public class SparseDataFrame extends DataFrame {
    protected int index=0;
    protected Object hide;
    public SparseDataFrame(String[] _name_of_columns, String[] _data_types,String _hide)throws NumberFormatException,WrongNames{
        super(_name_of_columns, _data_types);
        boolean flag=true;
        String firsttype=data_types[0];
        for(int i=1;i<data_types.length;++i){
            if(!data_types[i].matches(firsttype)){
                flag=false;
                break;
            }
        }
        if(!flag)throw new WrongNames();
        if(data_types[0].equals("int")){
            hide=Integer.parseInt(_hide);
        }else if(data_types[0].equals("boolean")){
            hide=Boolean.parseBoolean(_hide);
        }else if(data_types[0].equals("char")){
            hide=_hide.charAt(0);
        }else if(data_types[0].equals("double")){
            hide=Double.parseDouble(_hide);
        }else if(data_types[0].equals("float")){
            hide=Float.parseFloat(_hide);
        }else if(data_types[0].equals("long")){
            hide=Long.parseLong(_hide);
        }else hide=_hide;

        for(int i=0;i<name_of_columns.length;++i){
            table[i]=new ArrayList<CooValue>();
        }
    }
    public SparseDataFrame(DataFrame df,String _hide)throws WrongNames,OwnError{
        this(df.name_of_columns,df.data_types, _hide);
        Object[][]objects=new Object[df.size()][data_types.length];
        for (int i=0;i<df.size();i++){
            objects[i]=df.returnrow(i);
            this.add(objects[i]);
        }
    }

    public void add(Object ...a){
        for(int i=0;i<a.length;++i){
            if(Objects.equals(hide.getClass().getSimpleName(), "Integer")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Integer>(index,(int)a[i]));
                }
            }else if(Objects.equals(hide.getClass().getSimpleName(), "Character")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Character>(index,(char)a[i]));
                }
            }else if(Objects.equals(hide.getClass().getSimpleName(), "Boolean")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Boolean>(index,(boolean)a[i]));
                }
            }else if(Objects.equals(hide.getClass().getSimpleName(), "Double")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Double>(index,(double)a[i]));
                }
            }else if(Objects.equals(hide.getClass().getSimpleName(), "Float")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Float>(index,(float)a[i]));
                }
            }else if(Objects.equals(hide.getClass().getSimpleName(), "Long")){
                if(hide!=a[i]){
                    table[i].add(new CooValue<Long>(index,(long)a[i]));
                }
            }
        }
        index++;


    }
    public void test(){
        for(int i=0;i<table.length;++i){
            ArrayList<CooValue>arrayList=table[i];
            for(CooValue a:arrayList){
                System.out.println(a.getIndex()+" "+a.getValue());
            }
        }
    }
    public void display(){
        Object t[][];
        t=returnmatrix();
        for(int z=0;z<this.name_of_columns.length;++z){
            System.out.printf("%-20s | ",this.name_of_columns[z]);
        }
        System.out.println();
        for(int j=0;j<t[0].length;++j){
            for(int i=0;i<t.length;++i){
                System.out.printf("%-20s | ",t[i][j]);
            }
            System.out.println();
        }
    }

    public DataFrame toDense(){
        DataFrame dataFrame=new DataFrame(this.name_of_columns,this.data_types);
        dataFrame.table=new ArrayList[dataFrame.name_of_columns.length];
        Object t[][];
        t=returnmatrix();
        for(int i=0;i<table.length;++i){
            dataFrame.table[i]=new ArrayList<Objects>();
            for(int j=0;j<t[i].length;++j){
                dataFrame.table[i].add(t[i][j]);
                System.out.print(i+" "+j+"|");
            }
            System.out.println();
        }


        return dataFrame;
    }
    private Object[][]returnmatrix(){
        Object t[][]=new Object[data_types.length][index];
        for(int i=0;i<data_types.length;++i){
            for (int j=0;j<index;++j){
                t[i][j]=hide;
            }
        }
        for(int i=0;i<table.length;++i){
            ArrayList<CooValue>arrayList=table[i];
            for(CooValue a:arrayList){
                if(a.getValue()!=hide){
                    t[i][a.getIndex()]=a.getValue();
                }
            }
        }
        return t;
    }


}


class WrongNames extends Exception{
    WrongNames(){
    }
    public String getMessage(){
        return "Typy kolumn nie sa takie same";
    }
}
 final class CooValue<T>{
    private final int index;
    private final T value;
    public CooValue(int x,T v){
        index=x;
        value=v;
    }
    public int getIndex(){
        return index;
    }
    public T getValue(){
        return value;
    }
}

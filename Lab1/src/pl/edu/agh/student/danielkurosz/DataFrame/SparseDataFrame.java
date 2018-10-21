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
}

class WrongNames extends Exception{
    WrongNames(){
    }
    public String getMessage(){
        return "Typy kolumn nie sa takie same";
    }
}
class CooValue<T>{
    private int index;
    private T value;
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

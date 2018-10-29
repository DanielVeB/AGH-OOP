package pl.edu.agh.student.danielkurosz.crossword.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class CwDB {

    protected LinkedList<Entry> dict;
    public CwDB(String filename){
        dict=new LinkedList<>();
        createDB(filename);
    }
    public void add(String word,String clue){
        Entry entry=new Entry(word,clue);
        dict.push(entry);
    }
    public Entry get(String word)throws Wrongword{
        Entry entry=null;
        if(dict.size()==0)throw new Wrongword();
        for(int i=0;i<dict.size();++i){
            if(Objects.equals(dict.get(i).getWord(), word)){
                entry=dict.get(i);
                break;
            }
        }if(entry==null)throw new Wrongword();
        return entry;
    }
    public void remove(String word){
        for(int i=0;i<dict.size();++i) {
            if (Objects.equals(dict.get(i).getWord(), word)) {
                System.out.printf("Usunieto");
                dict.remove(i);
            }
        }

    }
    public void saveDB(String filename){


    }
    public int getSize(){
        return dict.size();
    }

    protected void createDB(String filename){
        //open file
        String line1=null;
        String line2=null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(( line1 = bufferedReader.readLine()) != null
                    && ( line2 = bufferedReader.readLine()) != null) {
                add(line1,line2);

            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filename + "'");

        }
    }

}
class Wrongword extends Exception{

}



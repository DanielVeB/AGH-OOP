package pl.edu.agh.student.danielkurosz.crossword.dictionary;

import java.util.LinkedList;
import java.util.Random;

public class InteliCwDB extends CwDB {
    public InteliCwDB(String filename){
        super(filename);
    }
    public LinkedList<Entry>findAll(String pattern){
        LinkedList<Entry>entries=new LinkedList<>();
        for(int i=0;i<dict.size();++i){
            if(dict.get(i).getWord().matches(pattern)){
                entries.add(dict.get(i));
            }
        }
        return entries;
    }
    public Entry getRandom(){
        Random random=new Random();
        int i=Math.abs(random.nextInt()%dict.size());
        return dict.get(i);
    }
    public Entry getRandom(int length)throws Wrongword{
        LinkedList<Entry>entries=new LinkedList<>();
        for(int i=0;i<dict.size();++i){
            if(dict.get(i).getWord().length()==length){
                entries.push(dict.get(i));
            }
        }
        if(entries.size()>0) {
            Random random = new Random();
            int i = Math.abs(random.nextInt() % entries.size());
            return entries.get(i);
        }
        else throw new Wrongword();

    }
    public Entry getRandom(String pattern){
        LinkedList<Entry> entries=findAll(pattern);
        Random random=new Random();
        int i=Math.abs(random.nextInt()%entries.size());
        return entries.get(i);
    }

    @Override
    public void add(String word, String clue) {
        Entry entry=new Entry(word,clue);
        dict.add(entry);
    }
}

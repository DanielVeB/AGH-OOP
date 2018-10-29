package pl.edu.agh.student.danielkurosz.crossword.dictionary;

public class Entry {


    protected String word;
    protected String clue;

    public Entry(String word,String clue){
        this.word=word;
        this.clue=clue;
    }
    public String getWord() {
        return word;
    }

    public String getClue() {
        return clue;
    }

}

package pl.edu.agh.student.danielkurosz.crossword.dictionary;

public class Main {
    public static void main(String[] args) {
        InteliCwDB inteliCwDB=new InteliCwDB("Crossword/fetch");
        System.out.println(inteliCwDB.getRandom("Agata").getClue());
    }
}

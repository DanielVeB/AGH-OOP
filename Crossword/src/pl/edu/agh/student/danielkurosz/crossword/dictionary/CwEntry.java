package pl.edu.agh.student.danielkurosz.crossword.dictionary;

import com.sun.javafx.scene.traversal.Direction;

public class CwEntry extends Entry{

    private int x;
    private int y;
    private Direction dir;
    public CwEntry(String word,String clue,int x,int y,Direction dir){
        super(word,clue);
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }

}

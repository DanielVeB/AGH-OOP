package pl.edu.agh.student.danielkurosz.zad3;
/**
 * @author Daniel Kurosz
 * @version 1
 */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVD {
    /**
     *
     * @param in  path to microdvd file from which we read
     * @param out path to output file
     * @param delay number of microseconds how much we want to delay the subtitles ( if delay is negative subtitles speeds up)
     * @param fps frame rate of movie
     * @throws IOException  path to file is wrong
     * @throws MyNumberFormatException wrong format of frame rate ,return number and content of this line
     * @throws Error first frame is bigger than last frame
     * @throws WrongLine wrong pattern of line
     */
    static void delay(String in, String out, int delay, int fps) throws IOException,MyNumberFormatException,Error,WrongLine {
        File file = new File(in);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(out, true));

        int numberofrates=delay/fps;

        String st;
        String regex="([{][^{}]*[}][{][^{}]*[}])";
        String text=new String();
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=null;
        int i=1;
        while ((st = reader.readLine()) != null){
            matcher=pattern.matcher(st);
            if(matcher.find()){
                String frames=matcher.group(0).substring(1,matcher.group(0).length()-1);
                int size=matcher.group(0).length();
                text=st.substring(size,st.length());
                int iend = frames.indexOf("}"); //this finds the first occurrence of "}"
                int startframe,lastframe;
                try {
                    startframe = Integer.parseInt(frames.substring(0, iend));
                    lastframe = Integer.parseInt(frames.substring(iend + 2, frames.length()));
                }catch (NumberFormatException ex){
                    throw new MyNumberFormatException(i,st);
                }
                if(startframe>lastframe)throw new Error(startframe,lastframe,i,text);
                startframe+=numberofrates;
                lastframe+=numberofrates;
                writer.append('{'+Integer.toString(startframe)+"}{"+Integer.toString(lastframe)+'}'+text);
                ++i;
            }else throw new WrongLine(i,st);
            writer.append("\n");
        }
        reader.close();
        writer.close();

    }

    public static void main(String[] args) {
        try {
            delay(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } catch (IOException | Error | WrongLine | MyNumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

class Error extends Exception{
    int i,j,linijka;
    String text;
    Error(int i,int j,int linijka,String text){
        this.i=i;
        this.j=j;
        this.linijka=linijka;
        this.text=text;
    }
    public String getMessage(){
        return "Linia "+linijka+" : {"+i+"}{"+j+"}"+text;
    }
}
class WrongLine extends Exception{
    String text;
    int i;
    WrongLine(int i,String text){
        this.i=i;
        this.text=text;
    }

    public String getMessage() {
        return ("Linia: "+i+" :"+text);
    }
}
class MyNumberFormatException extends Exception{
    int i;
    String text;
    public MyNumberFormatException(int i,String text){
        this.i=i;
        this.text=text;
    }
    public String getMessage() {
        return ("Linia: "+i+",Zły format klatek :"+text);
    }
}
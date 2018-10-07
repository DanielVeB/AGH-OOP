package pl.edu.agh.student.danielkurosz;


public class PeselProgram {

    public static void main(String[] args){
        Pesel pesel=null;
        try {
            pesel=new Pesel("88072789111");
            System.out.println(pesel.check());
        }catch (OwnException a){
        }

    }
}

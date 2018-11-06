package excp;

public class TooBigNumberException extends Exception {
    private int i;
    public TooBigNumberException(int i){
        this.i=i;
    }
    public String getMessage(){
       String message="Za duza liczba"+i+"> 10 !!!!";
       return message;
    }
}

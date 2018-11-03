package pl.edu.agh.student.danielkurosz.zad2i3;



class Pesel {
    private String numer;
    private int lastdigit;

    Pesel(String _numer)throws OwnException{
        if(_numer.length()!=11)throw new OwnException("Nieprawidlowa ilosc cyfr.");
        if(!Character.isDigit(_numer.charAt(10)))throw new OwnException("Wystepuje litera.Pesel niepoprawny");
        else {
            numer = _numer.substring(0, 10);
            lastdigit = Character.getNumericValue(_numer.charAt(10));

        }
    }
     public String returnnumber(){
        return numer+lastdigit;
    }

     boolean  check()throws OwnException{
        if(!numer.matches("[0-9]+")){
            throw new OwnException("Wystepuje litera");
        }

        return return_last_digit() == lastdigit;
    }
    private  int return_last_digit(){
        int number=0;
        int x=9;
        for(char n : numer.toCharArray()){
            int i=Character.getNumericValue(n);
            i*=x;
            x-=2;
            number+=i;
            if(x==5)x=3;
            if(x==-1)x=9;
        }
        return number%10;
    }
}
class OwnException extends Exception{
    OwnException(String message){
        System.out.println(message);
    }
}

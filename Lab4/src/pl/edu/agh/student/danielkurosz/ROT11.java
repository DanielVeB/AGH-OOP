package pl.edu.agh.student.danielkurosz;

public class ROT11 implements Algorithm{
    public String crypt(String text){
        String crypttext=new String();
        for(int i=0;i<text.length();++i){
            int ascii_value=(int)text.charAt(i);

            if(ascii_value>=65 && ascii_value<=90){
                ascii_value+=13;
                if(ascii_value>90){
                    int x=ascii_value-90;
                    ascii_value=64+x;
                }
            }else if(ascii_value>=97 && ascii_value<=122){
                ascii_value+=13;
                if(ascii_value>122){
                    int x=ascii_value-122;
                    ascii_value=96+x;
                }
            }
            crypttext+=(char)ascii_value;

        }

        return crypttext;
    }
    public String decrypt(String crypttext){
         String text=new String();

        for(int i=0;i<crypttext.length();++i){
            int ascii_value=(int)crypttext.charAt(i);

            if(ascii_value>=65 && ascii_value<=90){
                ascii_value-=13;
                if(ascii_value<65){
                    int x=65-ascii_value;
                    ascii_value=91-x;
                }
            }else if(ascii_value>=97 && ascii_value<=122){
                ascii_value-=13;
                if(ascii_value<97){
                    int x=97-ascii_value;
                    ascii_value=123-x;
                }
            }
            text+=(char)ascii_value;

        }
         return text;
    }
}

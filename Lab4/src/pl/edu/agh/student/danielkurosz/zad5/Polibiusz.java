package pl.edu.agh.student.danielkurosz.zad5;

public class Polibiusz implements Algorithm{
    char[][]Greek_alphabet=new char[][]{
            {'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}
    };

    public String crypt(String text){
        int code;
        String crypttext=new String();
        text=text.toUpperCase();
        for(int c=0;c<text.length();++c) {
            if(text.charAt(c)=='J')crypttext+="24";
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if(text.charAt(c)==Greek_alphabet[i][j]){
                        code=(i+1)*10+(j+1);
                        crypttext+=Integer.toString(code);
                    }
                }
            }
        }
        return crypttext;
    }
    public String decrypt(String crypttext){
        char l1,l2;
        String decrypttext=new String();
        for(int i=0;i<crypttext.length();i+=2){
            l1=crypttext.charAt(i);
            l2=crypttext.charAt(i+1);
            decrypttext+=Greek_alphabet[l1-'0'-1][l2-'0'-1];
        }
        return decrypttext;
    }
}

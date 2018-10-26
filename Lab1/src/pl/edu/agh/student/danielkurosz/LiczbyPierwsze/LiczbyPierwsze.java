package pl.edu.agh.student.danielkurosz.LiczbyPierwsze;

import java.util.regex.Matcher;

public class LiczbyPierwsze {
    public static boolean primaritytest(long number){
        if(number<=1)return false;
        if(number==2 || number==3)return true;
        if(number%2==0)return false;
        long sqrtnumber=(long) Math.floor(Math.sqrt(number));
        for (long i = 3L; i <= sqrtnumber; ++i)
            if (sqrtnumber % i == 0)
                return false;
        return true;
    }
}

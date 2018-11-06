package appl;

import java.io.FileNotFoundException;

public interface Saveable {
     void SavetoFile(double x,String filename)throws FileNotFoundException;
}

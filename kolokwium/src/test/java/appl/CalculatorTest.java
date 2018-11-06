package appl;

import excp.TooBigNumberException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void AddToCalculator(){

        Calculator calculator=new Calculator();

        assertEquals("result should be 20",20,calculator.Add(20).getResult(),0.001);
    }
    @Test
    public void Divide(){
        Calculator calculator=new Calculator();
        calculator.Add(120);
        assertEquals(10,calculator.Divide(12).getResult(),0.001);
        assertEquals(2.5,calculator.Divide(4).getResult(),0.001);
    }
    @Test public void throwsTooBigNumberException() {
        try {
            Calculator calculator = new Calculator();
            calculator.Add(12).Factorial();
            fail("Expected TooBigNumberException to be thrown");
        } catch( TooBigNumberException ex ) {
        }
    }
}

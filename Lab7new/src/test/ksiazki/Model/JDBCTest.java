package ksiazki.Model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JDBCTest {
    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void shouldthrowInvalidISBNExceptionBecauseOfLength() throws InvalidISBN,SQLException{
        thrown.expect(InvalidISBN.class);
        thrown.expectMessage("Invalid value of isbn. Should be 13 digits");
        JDBC.addBook("12",null,null,0);
    }
    @Test public void shouldthrowInvalidISBNExceptionBecauseOfLetterInISBN() throws InvalidISBN,SQLException{
        thrown.expect(InvalidISBN.class);
        thrown.expectMessage("Invalid value of isbn. Should be 13 digits");
        JDBC.addBook("123456789a123",null,null,0);
    }
    @Test public void shouldthrowSQLException() throws  SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        thrown.expect(SQLException.class);
        JDBC.connect("jdbc:mysql://mysql.agh.edu.pl/danielku","danielku","niepoprawnehaslo");
    }



}
package ksiazki.Model;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class JDBC {
    private static Connection conn = null;

    public static void connect(String url,String user,String password) throws IllegalAccessException,InstantiationException,SQLException,ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        conn=DriverManager.getConnection(url,user,password);

    }
    public static ResultSet returnbyAuthor(String author){
        String SQL="SELECT * FROM books WHERE author LIKE ?";
        ResultSet rs=null;
        CachedRowSetImpl crs = null;
        try(PreparedStatement pstmt=conn.prepareStatement(SQL)){
            pstmt.setString(1,"%"+author);
            rs=pstmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return crs;
    }
    public static ResultSet returnbyisbn(String isbn){
        String SQL="SELECT * FROM books WHERE isbn=?";
        ResultSet rs=null;
        CachedRowSetImpl crs = null;
        try(PreparedStatement pstmt=conn.prepareStatement(SQL)){
            pstmt.setString(1,isbn);
            rs=pstmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return crs;
    }
    public static void addBook(String isbn,String author,String title,int year)throws Exception{
        //check isbn value
        if(!isbn.matches("[0-9]{13}")){
            throw new Exception("Invalid value of isbn. Should be 13 digits");
        }
        String SQL="INSERT INTO books VALUES(?,?,?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(SQL);
        preparedStmt.setString (1, isbn);
        preparedStmt.setString (2, title);
        preparedStmt.setString   (3, author);
        preparedStmt.setInt    (4, year);
        preparedStmt.execute();


    }
    public static void closeconnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}

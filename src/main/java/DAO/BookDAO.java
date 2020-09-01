
package DAO;
import Beans.BookBeen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;


public class BookDAO {
    
    public void addBook(BookBeen mybook){
        
        try {
            
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt;
            
            stmt = con.prepareStatement("INSERT INTO book(name,author,description,uprice) values(?,?,?,?)");
            stmt.setString(1,mybook.getName());
            stmt.setString(2, mybook.getAuthor());
            stmt.setString(3, mybook.getDescription());
            stmt.setFloat(4, mybook.getUprice());
            stmt.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
    }
    
    public ResultSet AddToCart(String name){

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM book WHERE name=?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            con.close();
            
            return rs;   


        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
        return null;

    }
    
    
}

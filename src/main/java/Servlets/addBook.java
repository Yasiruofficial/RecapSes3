package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addBook")
public class addBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String name = request.getParameter("Name");
            String author = request.getParameter("author");
            String description = request.getParameter("des");
            String uprice = request.getParameter("uprice");
        
        try {
           
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/onlinebookstore","root","admin");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO book(name,author,description,uprice) values(?,?,?,?)");
            
            stmt.setString(1,name);
            stmt.setString(2, author);
            stmt.setString(3, description);
            stmt.setFloat(4, Float.parseFloat(uprice));
            
            stmt.executeUpdate();

            con.close();
            
            
        } catch (SQLException ex) {
            
            System.out.println(ex);
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println(ex);
            
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

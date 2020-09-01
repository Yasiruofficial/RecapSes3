package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addToCart")
public class addToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String name = request.getParameter("Name");
            String qty = request.getParameter("qty");

             try {
                 
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/onlinebookstore","root","admin");
            
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM book WHERE name=?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            
            con.close();       
            
            request.setAttribute("ResultSet", rs);
            request.setAttribute("qty", qty);
            request.getRequestDispatcher("/display.jsp").forward(request,response);

            
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

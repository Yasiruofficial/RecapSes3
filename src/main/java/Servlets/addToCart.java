package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DBConnection;


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

            Connection con = DBConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM book WHERE name=?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            con.close();       
            
            request.setAttribute("ResultSet", rs);
            request.setAttribute("qty", qty);
            request.getRequestDispatcher("/display.jsp").forward(request,response);

            
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
            

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

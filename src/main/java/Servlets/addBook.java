package Servlets;

import Model.BookBeen;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String name = request.getParameter("Name");
            String author = request.getParameter("author");
            String description = request.getParameter("des");
            float uprice = Float.parseFloat(request.getParameter("uprice"));

           BookBeen book = new BookBeen();

            book.setName(name);
            book.setAuthor(author);
            book.setDescription(description);
            book.setUprice(uprice);


        try {

            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/onlinebookstore","root","");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO book(name,author,description,uprice) values(?,?,?,?)");

            stmt.setString(1,book.getName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getAuthor());
            stmt.setFloat(4, book.getUprice());

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

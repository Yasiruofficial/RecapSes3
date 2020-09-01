/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.BookBeen;
import DAO.BookDAO;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BookServlet", urlPatterns = {"/Book/addToCart","/Book/addBook"})
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
         String path = request.getRequestURI();

         if(path.equals("/Book/addBook")){
             
            String name = request.getParameter("Name");
            String author = request.getParameter("author");
            String description = request.getParameter("des");
            String uprice = request.getParameter("uprice");

            BookBeen book1 = new BookBeen();
        
            book1.setName(name);
            book1.setAuthor(author);
            book1.setDescription(description);
            book1.setUprice(Float.parseFloat(uprice));
        
            BookDAO bookdao = new BookDAO();   
            bookdao.addBook(book1);
             
         }
         else if(path.equals("/Book/addToCart")){

            String name = request.getParameter("Name");
            String qty = request.getParameter("qty");

            BookDAO book1 = new BookDAO();
            ResultSet rs = book1.AddToCart(name);
            request.setAttribute("ResultSet", rs);
            request.setAttribute("qty", qty);
        
            request.getRequestDispatcher("/display.jsp").forward(request,response);
             
         }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

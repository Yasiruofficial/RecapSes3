<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            if(request.getAttribute("ResultSet") == null){
                
                out.print("Wrong Input");
            }
            else{
                
                out.print("<h1 align=\"center\">Details</h1>");
                ResultSet rs = (ResultSet)request.getAttribute("x");
                
                try {
                    
                    while (rs.next()) {
                        
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    float uprice = Float.parseFloat(rs.getString("uprice"));
                    String qty = (String)request.getAttribute("qty");
                    float Fqty = Float.parseFloat(qty);

                    
                    out.print("<table align=\"center\">");
                    out.print("<tr>");
                        out.print("<td>"); out.print("Name"); out.print("<td>");
                        out.print("<td>"); out.print(name); out.print("<td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>"); out.print("Author"); out.print("<td>");
                        out.print("<td>"); out.print(author); out.print("<td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>"); out.print("Unit Price"); out.print("<td>");
                        out.print("<td>"); out.print(uprice); out.print("<td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>"); out.print("Quantity"); out.print("<td>");
                        out.print("<td>"); out.print(qty); out.print("<td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                        out.print("<td>"); out.print("Total Amount"); out.print("<td>");
                        out.print("<td>"); out.print(Fqty * uprice); out.print("<td>");
                    out.print("</tr>");
                    
                    out.print("</table>");
    
                    }  
                } catch (SQLException ex) {
                    
                    System.out.println("Error");
                }
                
            }
        
        %>
        
        
    </body>
</html>

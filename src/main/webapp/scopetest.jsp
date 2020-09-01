<%-- 
    Document   : scopetest
    Created on : Sep 1, 2020, 8:37:01 AM
    Author     : yasir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Scope Test Page</h1><br>
        <%
            
            out.print("Request attribute : " + request.getAttribute("req"));
            out.print("<br>");
            out.print("Session attribute : " + session.getAttribute("ses"));
            out.print("<br>");
            out.print("Page attribute : " + pageContext.getAttribute("pc"));
            out.print("<br>");
            out.print("Application attribute : " + application.getAttribute("app"));
            out.print("<br>");
            
        %>

        <form action="scope.jsp" method="get">
            <input type="submit" name="submit" value="Go Back">  
        </form>
        
    </body>
</html>

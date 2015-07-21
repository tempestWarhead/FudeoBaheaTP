<%-- 
    Document   : erro
    Created on : 20/07/2015, 22:59:31
    Author     : LucasCésar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="well" style="margin: 3% 30%">
            <p class="text-center"><%=request.getAttribute("erro")%></p>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tp.model.domain.Categoria" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP</title>
    </head>
    <body>
        <center>
            <h3>Lista de Categorias</h3>
            <a href='/tp/InserirCategoria.jsp'>Nova Categoria</a>
            <form name="formCategoria" method='post' action='/tp/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Categoria'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Categoria> listCategoria = (List<Categoria>) request.getAttribute("listCategoria");
                        for (Categoria categoria: listCategoria) {
                    %>
                        <tr>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarCategoria&CodCategoria=<%=categoria.getId()%>"><%=categoria.getId()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarCategoria&CodCategoria=<%=categoria.getId()%>"><%=categoria.getNome()%></a>
                            </td>
                            <td>
                                <input type='button' value='Excluir' onclick='Excluir(<%=categoria.getId()%>,document.formCategoria)'>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>

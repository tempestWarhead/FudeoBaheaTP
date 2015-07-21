<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tp.model.domain.Produto" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP</title>
    </head>
    <body>
        <center>
            <h3>Lista de Produtos</h3>
            <a href='/tp/InserirProduto.jsp'>Novo Produto</a>
            <form name="formProduto" method='post' action='/tp/servletweb'>
                <input type='hidden' name='acao' value=''>
                <input type='hidden' name='cod' value=''>
                <input type='hidden' name='table' value='Produto'>
                <table>
                    <tr>
                        <td>
                            Código
                        </td>
                        <td>
                            Nome
                        </td>
                        <td>
                            Preço
                        </td>
                        <td>
                            Categoria
                        </td>
                        <td>
                            Fornecedor
                        </td>
                        <td>
                            Descrição
                        </td>
                        
                        <td>
                            &nbsp
                        </td>
                    </tr>
                    <%
                        List<Produto> listProduto = (List<Produto>) request.getAttribute("listProduto");
                        for (Produto produto: listProduto) {
                    %>
                        <tr>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getId()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getNome()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getPreco()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getCategoria_id()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getFornecedor_id()%></a>
                            </td>
                            <td>
                                <a href="/tp/servletweb?acao=AlterarProduto&CodProduto=<%=produto.getId()%>"><%=produto.getDescricao()%></a>
                            </td>
                            <td>
                                <input type='button' value='Excluir' onclick='Excluir(<%=produto.getId()%>,document.formProduto)'>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
    </body>
</html>

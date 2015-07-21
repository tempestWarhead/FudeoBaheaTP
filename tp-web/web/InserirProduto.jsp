<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tp.model.domain.Categoria" %>
<%@page import="tp.model.domain.Fornecedor" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP</title>
    </head>
    <body>
        <center>
            <h3>Inserir Produto</h3>
            <form name="formInserirProduto" method='post'>
                <input type='hidden' name='table' value='Produto'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome do Produto:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Preço:
                        </td>
                        <td>
                            <input type='text' name='preco' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Categoria:
                        </td>
                        <td>
                            <select name='cod_categoria'>
                                <%
                                    List<Categoria> listCategoria = (List<Categoria>) request.getAttribute("listCategoria"); 
                                    for (Categoria categoria : listCategoria) {
                                %>
                                        <option                                     
                                            value='<%=categoria.getId()%>'><%=categoria.getNome()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td>
                            Descrição:
                        </td>
                        <td>
                            <input type='text' name='descricao' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fornecedor:
                        </td>
                        <td>
                            <select name='cod_fornecedor'>
                                <%
                                    List<Fornecedor> listFornecedor = (List<Fornecedor>) request.getAttribute("listFornecedor"); 
                                    for (Fornecedor fornecedor : listFornecedor) {
                                %>
                                        <option                                     
                                            value='<%=fornecedor.getId()%>'><%=fornecedor.getNome()%>
                                        </option>
                                <%  } %>
                            </select>
                        </td>                        
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.formInserirProduto)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/tp/servletweb?acao=ListarProduto'>Listar Produtos</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>

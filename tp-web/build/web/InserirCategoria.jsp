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
            <h3>Inserir Produto</h3>
            <form name="formInserirCategoria" method='post'>
                <input type='hidden' name='table' value='Categoria'>
                <input type='hidden' name='acao' value='gravar'>
                <table>
                    <tr>
                        <td>
                            Nome da Categoria:
                        </td>
                        <td>
                            <input type='text' name='nome' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' aling='center'>
                            <input type='button' onclick="GravarAlterarTabela(document.formInserirCategoria)" value='Gravar'>&nbsp;
                            <input type='reset' value='Redefinir'>
                            <a href='/tp/servletweb?acao=ListarCategoria'>Listar Categorias</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>

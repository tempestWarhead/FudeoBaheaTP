<%-- 
    Document   : cadastrarFornecedor
    Created on : 20/07/2015, 21:14:38
    Author     : LucasCésar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TP - Cadastro Fornecedor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>


    <body>
        <nav class="navbar navbar-default navbar-static-top" style="width: 100%; margin: 0px">
            <div class="container-fluid">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="index.html" class="navbar-brand text-center" style="padding-left: 50px">TP</a>

                </div>
                <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.html"> Home <span class="sr-only">(current)</span></a></li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="well" style="margin: 3% 30%">
            <form method="POST" action="inserirFornecedor">
                <div class="form-group">
                    <label for="nome">Nome do fornecedor:</label>
                    <input type="nome" class="form-control" id="nome" name="nome" placeholder="Nome do fornecedor">
                </div>
                <div class="form-group">
                    <label for="rs">Razão Social:</label>
                    <input type="rs" class="form-control" id="razaoSocial" name="razaoSocial" placeholder="Razão Social">
                </div>
                <input type="submit" value="cadastrar">
            </form>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

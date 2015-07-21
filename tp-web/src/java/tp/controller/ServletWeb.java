package tp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        
        
        request.getParameter("nome");
        if(acao.equals("loginUsuario"))
            jsp = loginUsuario.execute(request);
        
        else if (acao.equals("listarUsuario"))
            jsp = listarUsuario.execute(request);
        
        else if (acao.equals("alterarUsuario"))
            jsp = alterarUsuario.execute(request);
        
        else if (acao.equals("gravarAlteracaoUsuario"))
            jsp = gravarAlteracaoUsuario.execute(request);
        
        else if (acao.equals("gravarInsercaoUsuario"))
            jsp = gravarInsercaoUsuario.execute(request);
        
        else if (acao.equals("excluirUsuario"))
            jsp = excluirUsuario.execute(request);

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    
}

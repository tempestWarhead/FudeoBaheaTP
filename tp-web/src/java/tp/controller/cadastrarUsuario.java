
package tp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import tp.model.domain.Usuario;
import tp.model.service.IManterUsuario;
import tp.model.service.impl.ManterUsuario;


public class cadastrarUsuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterUsuario manterUsuario = new ManterUsuario();
            List<Usuario> listUsuario = manterUsuario.pesquisarTodos();
            
            request.getParameter("");
            
            if (listUsuario != null) {
                request.setAttribute("listUsuario", listUsuario);
                jsp = "/inserirusuario.jsp";
            } else {
                String erro = "Nao existem registros!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}

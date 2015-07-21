
package tp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import tp.model.domain.Usuario;
import tp.model.service.IManterUsuario;
import tp.model.service.impl.ManterUsuario;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pernambucanas
 */
public class listarUsuario {

    static String execute(HttpServletRequest request) {
       String jsp = "";
        try {
            IManterUsuario manterUsuario = new ManterUsuario();
            List<Usuario> listUsuario = manterUsuario.pesquisarTodos();
            if (listUsuario != null) {
                request.setAttribute("listUsuario", listUsuario);
                jsp = "/listarusuario.jsp";
            } else {
                String erro = "Nao existe registro!";
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


package tp.controller;

import javax.servlet.http.HttpServletRequest;
import tp.model.domain.Usuario;
import tp.model.service.IManterUsuario;
import tp.model.service.impl.ManterUsuario;

public class excluirUsuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodUsuario que se deseja alterar
            Long usuarioId = Long.parseLong(request.getParameter("cod"));
            IManterUsuario manterUsuario = new ManterUsuario();
            Usuario usuario = manterUsuario.pesquisarPorId(usuarioId);
            boolean delete = manterUsuario.excluir(usuario);
            if (delete != false) {
                jsp = listarUsuario.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Usuario!";
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

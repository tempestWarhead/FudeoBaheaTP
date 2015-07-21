package tp.controller;

import javax.servlet.http.HttpServletRequest;
import tp.model.domain.Usuario;
import tp.model.service.IManterUsuario;
import tp.model.service.impl.ManterUsuario;
import java.util.Date;
import javafx.scene.chart.PieChart.Data;

public class gravarAlteracaoUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long codUsuario = Long.parseLong(request.getParameter("codUsuario"));
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String sexo = request.getParameter("sexo");
            //Date dataNasc = request.getParameter("dataNasc");
            String tel = request.getParameter("tel");
            
            String tipoEndereco = request.getParameter("tipoEndereco");
            String cep =request.getParameter("cep");
            String endereco = request.getParameter("endereco");
            int numero = Integer.parseInt( request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            Usuario usuario = new Usuario();
            usuario.setId(codUsuario);
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            usuario.setSexo(sexo);
            //usuario.setDataNasc(dataNasc);
            usuario.setTel(tel);
            usuario.setTipoEndereco(tipoEndereco);
            usuario.setCep(cep);
            usuario.setEndereco(endereco);
            usuario.setNumero(numero);
            usuario.setComplemento(complemento);
            usuario.setBairro(bairro);
            usuario.setCidade(cidade);
            usuario.setEstado(estado);

            IManterUsuario manterUsuario = new ManterUsuario();
            boolean updated = manterUsuario.alterar(usuario);

            if (updated == true) {
                jsp = listarUsuario.execute(request);
            } else {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
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

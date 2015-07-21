package tp.model.DAO.impl;

import tp.model.DAO.IUsuarioDAO;
import tp.model.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.bd.ConnectionManager;
import util.bd.exception.PersistenciaException;
import java.sql.Date;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Long inserir(Usuario usuario) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO usuario (nome, cpf, senha, email, sexo, dataNasc, tel, tipoEndereco, cep, endereco, numero, complemento, bairro, cidade, estado) VALUES(?,?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getSexo());
            statement.setString(6,  usuario.getDataNasc());
            statement.setString(7, usuario.getTel());
            statement.setString(8, usuario.getTipoEndereco());
            statement.setString(9, usuario.getCep());
            statement.setString(10, usuario.getEndereco());
            statement.setInt(11, usuario.getNumero());
            statement.setString(12, usuario.getComplemento());
            statement.setString(13, usuario.getBairro());
            statement.setString(14, usuario.getCidade());
            statement.setString(15, usuario.getEstado());
            
            ResultSet result = statement.executeQuery();

            Long id = null;
            if (result.next()) {
                id = new Long(result.getLong("id"));
                usuario.setId(id);
            }

            result.close();
            statement.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Usuario usuario) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE usuario "
                    + "   SET nome = ?, "
                    + "       cpf = ?, "
                    + "       senha = md5(?), "
                    + "       email = ? "
                    + "       sexo = ? "
                    + "       dataNasc = ? "
                    + "       tel = ? "
                    + "       tipoEndereco = ? "
                    + "       cep = ? "
                    + "       endereco = ? "
                    + "       numero = ? "
                    + "       complemento = ? "
                    + "       bairro = ? "
                    + "       cidade = ? "
                    + "       estado = ? "
                    + " WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getSexo());
            statement.setString(6, usuario.getDataNasc());
            statement.setString(7, usuario.getTel());
            statement.setString(8, usuario.getTipoEndereco());
            statement.setString(9, usuario.getCep());
            statement.setString(10, usuario.getEndereco());
            statement.setInt(11, usuario.getNumero());
            statement.setString(12, usuario.getComplemento());
            statement.setString(13, usuario.getBairro());
            statement.setString(14, usuario.getCidade());
            statement.setString(15, usuario.getEstado());
            
            statement.executeUpdate();
            statement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Usuario usuario) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM usuario WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, usuario.getId());
            statement.executeUpdate();

            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario ORDER BY nomecompleto";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            ArrayList<Usuario> listAll = null;
            if (result.next()) {
                listAll = new ArrayList<>();
                do {
                    Usuario usuario = new Usuario();
                    usuario.setId(result.getLong("id"));
                    usuario.setNome(result.getString("nome"));
                    usuario.setCpf(result.getString("cpf"));
                    usuario.setSenha(result.getString("senha"));
                    usuario.setEmail(result.getString("email"));
                    usuario.setSexo(result.getString("sexo"));
                    usuario.setDataNasc(result.getString("dataNasc"));
                    usuario.setTel(result.getString("tel"));
                    usuario.setTipoEndereco(result.getString("tipoEndereco"));
                    usuario.setCep(result.getString("cep"));
                    usuario.setEndereco(result.getString("endereco"));
                    usuario.setNumero(result.getInt("numero"));
                    usuario.setComplemento(result.getString("complemento"));
                    usuario.setBairro(result.getString("bairro"));
                    usuario.setCidade(result.getString("cidade"));
                    usuario.setEstado(result.getString("estado"));
                    
                    
                    listAll.add(usuario);
                } while (result.next());
            }

            result.close();
            statement.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Usuario consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            Usuario usuario = null;
            if (result.next()) {
                usuario = new Usuario();
                usuario.setId(result.getLong("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setCpf(result.getString("cpf"));
                usuario.setSenha(result.getString("senha"));
                usuario.setEmail(result.getString("email"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setDataNasc(result.getString("dataNasc"));
                usuario.setTel(result.getString("tel"));
                usuario.setTipoEndereco(result.getString("tipoEndereco"));
                usuario.setCep(result.getString("cep"));
                usuario.setEndereco(result.getString("endereco"));
                usuario.setNumero(result.getInt("numero"));
                usuario.setComplemento(result.getString("complemento"));
                usuario.setBairro(result.getString("bairro"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
            }

            result.close();
            statement.close();
            connection.close();

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Usuario consultarPorEmailSenha(String email, String senha) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = md5(?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(4, email);
            statement.setString(3, senha);
            ResultSet result = statement.executeQuery();

            Usuario usuario = null;
            if (result.next()) {
                usuario = new Usuario();
                usuario.setId(result.getLong("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setCpf(result.getString("cpf"));
                usuario.setSenha(result.getString("senha"));
                usuario.setEmail(result.getString("email"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setDataNasc(result.getString("dataNasc"));
                usuario.setTel(result.getString("tel"));
                usuario.setTipoEndereco(result.getString("tipoEndereco"));
                usuario.setCep(result.getString("cep"));
                usuario.setEndereco(result.getString("endereco"));
                usuario.setNumero(result.getInt("numero"));
                usuario.setComplemento(result.getString("complemento"));
                usuario.setBairro(result.getString("bairro"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
            }

            result.close();
            statement.close();
            connection.close();

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}

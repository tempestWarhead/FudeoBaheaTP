package tp.model.dao.impl;

import tp.model.dao.IFornecedorDAO;
import tp.model.domain.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.db.ConnectionManager;
import util.db.exception.PersistenciaException;

public class FornecedorDAO implements IFornecedorDAO {

    @Override
    public Long inserir(Fornecedor fornecedor) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO fornecedor (nome, razaoSocial) VALUES(?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getRazaoSocial());
            
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                fornecedor.setId(id);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Fornecedor fornecedor) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE fornecedor "
                    + "   SET nome = ?, "
                    + "       razaoSocial = ? "
                    + " WHERE id = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getRazaoSocial());
            pstmt.setLong(3, fornecedor.getId());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Fornecedor fornecedor) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM fornecedor WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, fornecedor.getId());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Fornecedor> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM fornecedor ORDER BY nome";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Fornecedor> listAll = null;
            
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Fornecedor fornecedor = new Fornecedor();
                    
                    fornecedor.setId(rs.getLong("id"));
                    fornecedor.setNome(rs.getString("nome"));
                    fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                    
                    listAll.add(fornecedor);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Fornecedor consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM fornecedor WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Fornecedor fornecedor = null;
            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getLong("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return fornecedor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}

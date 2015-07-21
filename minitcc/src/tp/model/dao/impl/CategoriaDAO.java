package tp.model.dao.impl;

import java.util.ArrayList;
import tp.model.domain.Categoria;
import tp.model.dao.ICategoriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tp.util.db.ConnectionManager;
import tp.util.db.exception.PersistenciaException;

public class CategoriaDAO implements ICategoriaDAO {
    @Override
    public Long inserir(Categoria categoria) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO categoria (nome) VALUES(?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, categoria.getNome());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                categoria.setId(id);
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
    public boolean atualizar(Categoria categoria) throws PersistenciaException {
         try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE categoria " +
                         "   SET nome = ? " +
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, categoria.getNome());
            pstmt.setLong(2, categoria.getId());
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
    public boolean delete(Categoria categoria) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM categoria WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, categoria.getId());
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
    public ArrayList<Categoria> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM categoria ORDER BY descricao";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Categoria> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getLong("id"));
                    categoria.setNome(rs.getString("nome"));
                    listAll.add(categoria);
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
    public Categoria consultarPorId(Long id) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM categoria WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Categoria categoria = null;
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return categoria;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}

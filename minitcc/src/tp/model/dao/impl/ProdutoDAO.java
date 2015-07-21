package tp.model.dao.impl;

import java.util.ArrayList;
import tp.model.domain.Produto;
import tp.model.dao.IProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tp.util.db.ConnectionManager;
import tp.util.db.exception.PersistenciaException;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Long inserir(Produto produto) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO produto (nome, preco, descricao, categoria_id, fornecedor_id) VALUES(?, ?, ?, ?, ?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setString(3, produto.getDescricao());
            pstmt.setLong(4, produto.getCategoria_id());
            pstmt.setLong(5, produto.getFornecedor_id());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                produto.setId(id);
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
    public boolean atualizar(Produto produto) throws PersistenciaException {
         try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE produto " +
                         "   SET nome = ?, " +
                         "       preco = ?, " +
                         "       descricao = ?, " +
                         "       categoria_id = ?, " +
                         "       fornecedor_id = ? " +
                         " WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setString(3, produto.getDescricao());
            pstmt.setLong(4, produto.getCategoria_id());
            pstmt.setLong(5, produto.getFornecedor_id());
            pstmt.setLong(6, produto.getId());
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
    public boolean delete(Produto produto) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM produto WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, produto.getId());
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
    public ArrayList<Produto> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM produto ORDER BY descricao";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Produto> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Produto produto = new Produto();
                    produto.setId(rs.getLong("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCategoria_id(rs.getLong("categoria_id"));
                    produto.setFornecedor_id(rs.getLong("fornecedor_id"));
                    listAll.add(produto);
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
    public Produto consultarPorId(Long id) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM produto WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Produto produto = null;
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCategoria_id(rs.getLong("categoria_id"));
                produto.setFornecedor_id(rs.getLong("fornecedor_id"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return produto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}

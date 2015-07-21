package tp.model.dao;

import tp.model.domain.Produto;
import tp.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public interface IProdutoDAO {
    Long inserir(Produto produto) throws PersistenciaException;

    boolean atualizar(Produto produto) throws PersistenciaException;

    boolean delete(Produto produto) throws PersistenciaException;

    ArrayList<Produto> listarTodos() throws PersistenciaException;

    Produto consultarPorId(Long id) throws PersistenciaException;
}
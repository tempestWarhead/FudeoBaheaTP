package tp.model.dao;

import tp.model.domain.Categoria;
import tp.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public interface ICategoriaDAO {
    Long inserir(Categoria categoria) throws PersistenciaException;

    boolean atualizar(Categoria categoria) throws PersistenciaException;

    boolean delete(Categoria categoria) throws PersistenciaException;

    ArrayList<Categoria> listarTodos() throws PersistenciaException;

    Categoria consultarPorId(Long id) throws PersistenciaException;
}
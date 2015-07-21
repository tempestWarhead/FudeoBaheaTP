package tp.model.service;

import tp.model.domain.Categoria;
import tp.util.db.exception.*;
import java.util.List;

public interface IManterCategoria {
    public Long cadastrar(Categoria categoria) throws PersistenciaException, NegocioException;
    public boolean alterar(Categoria categoria) throws PersistenciaException, NegocioException;
    public boolean excluir(Categoria categoria) throws PersistenciaException, NegocioException;
    public List<Categoria> pesquisarTodos() throws PersistenciaException;
    public Categoria pesquisarPorId(Long id) throws PersistenciaException;    
}

package tp.model.service;

import tp.model.domain.Produto;
import tp.util.db.exception.*;
import java.util.List;

public interface IManterProduto {
    public Long cadastrar(Produto produto) throws PersistenciaException, NegocioException;
    public boolean alterar(Produto produto) throws PersistenciaException, NegocioException;
    public boolean excluir(Produto produto) throws PersistenciaException, NegocioException;
    public List<Produto> pesquisarTodos() throws PersistenciaException;
    public Produto pesquisarPorId(Long id) throws PersistenciaException;    
}

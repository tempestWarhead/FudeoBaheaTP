package tp.model.dao;

import tp.model.domain.Fornecedor;
import util.db.exception.PersistenciaException;
import java.util.ArrayList;

public interface IFornecedorDAO {

    Long inserir(Fornecedor fornecedor) throws PersistenciaException;

    boolean atualizar(Fornecedor fornecedor) throws PersistenciaException;

    boolean delete(Fornecedor fornecedor) throws PersistenciaException;

    ArrayList<Fornecedor> listarTodos() throws PersistenciaException;

    Fornecedor consultarPorId(Long id) throws PersistenciaException;
}

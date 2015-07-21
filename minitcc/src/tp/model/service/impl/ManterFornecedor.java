package tp.model.service.impl;

import tp.model.dao.IFornecedorDAO;
import tp.model.dao.impl.FornecedorDAO;
import tp.model.domain.Fornecedor;
import tp.model.service.IManterFornecedor;
import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;
import java.util.List;

public class ManterFornecedor implements IManterFornecedor {

    private IFornecedorDAO fornecedorDAO;
    
    public ManterFornecedor() {
        fornecedorDAO = new FornecedorDAO();
    }
    
    @Override
    public Long cadastrar(Fornecedor fornecedor) throws PersistenciaException, NegocioException {
        
        if((fornecedor.getNome() == null) || (fornecedor.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if( (fornecedor.getRazaoSocial() == null) || (fornecedor.getRazaoSocial().isEmpty()) )
            throw new NegocioException("Obrigatório informar a Razão Social.");
        
        Long result = fornecedorDAO.inserir(fornecedor);
        return result;
    }

    @Override
    public boolean alterar(Fornecedor fornecedor) throws PersistenciaException, NegocioException {
        
        if((fornecedor.getNome() == null) || (fornecedor.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if( (fornecedor.getRazaoSocial() == null) || (fornecedor.getRazaoSocial().isEmpty()) )
            throw new NegocioException("Obrigatório informar a Razão Social.");
                  
        boolean result = fornecedorDAO.atualizar(fornecedor);
        return result;
    }

    @Override
    public boolean excluir(Fornecedor fornecedor) throws PersistenciaException, NegocioException {
        
        boolean result = fornecedorDAO.delete(fornecedor);
        return result;       
    }

    @Override
    public List<Fornecedor> listarTodos() throws PersistenciaException {
        List<Fornecedor> result = fornecedorDAO.listarTodos();
        return result;
    }

    @Override
    public Fornecedor pesquisarPorId(Long id) throws PersistenciaException {
        Fornecedor result = fornecedorDAO.consultarPorId(id);
        return result;       
    }
}

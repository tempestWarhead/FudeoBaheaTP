package tp.model.service.impl;

import tp.model.dao.IProdutoDAO;
import tp.model.dao.impl.ProdutoDAO;
import tp.model.domain.Produto;
import tp.model.service.IManterProduto;
import tp.util.db.exception.NegocioException;
import tp.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterProduto implements IManterProduto {
    private IProdutoDAO produtoDAO;
    
    public ManterProduto() {
        produtoDAO = new ProdutoDAO();
    }
    
    @Override
    public Long cadastrar(Produto produto) throws PersistenciaException, NegocioException {
        if((produto.getNome() == null) || (produto.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        if((produto.getDescricao() == null) || (produto.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar a descrição do produto.");
        if(produto.getPreco() == null)
            throw new NegocioException("Obrigatório informar o preço do produto.");
        if(produto.getPreco() < 0)
            throw new NegocioException("Valor inválido de preço de produto.");
        if(produto.getCategoria_id() == null)
            throw new NegocioException("Obrigatório atribuir uma categoria ao produto.");
        if(produto.getFornecedor_id() == null)
            throw new NegocioException("Obrigatório informar o fornecedor do produto.");

        Long result = produtoDAO.inserir(produto);
        return result;
    }

    @Override
    public boolean alterar(Produto produto) throws PersistenciaException, NegocioException {
        if((produto.getNome() == null) || (produto.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        if((produto.getDescricao() == null) || (produto.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar a descrição do produto.");
        if(produto.getPreco() == null)
            throw new NegocioException("Obrigatório informar o preço do produto.");
        if(produto.getPreco() < 0)
            throw new NegocioException("Valor inválido de preço de produto.");
        if(produto.getCategoria_id() == null)
            throw new NegocioException("Obrigatório atribuir uma categoria ao produto.");
        if(produto.getFornecedor_id() == null)
            throw new NegocioException("Obrigatório informar o fornecedor do produto.");

        boolean result = produtoDAO.atualizar(produto);
        return result;
    }

    @Override
    public boolean excluir(Produto produto) throws PersistenciaException, NegocioException {
        boolean result = produtoDAO.delete(produto);
        return result;
    }

    @Override
    public List<Produto> pesquisarTodos() throws PersistenciaException {
        List<Produto> result = produtoDAO.listarTodos();
        return result;
    }

    @Override
    public Produto pesquisarPorId(Long id) throws PersistenciaException {
        Produto result = produtoDAO.consultarPorId(id);
        return result;       
    }
}

package tp.model.service.impl;

import tp.model.dao.ICategoriaDAO;
import tp.model.dao.impl.CategoriaDAO;
import tp.model.domain.Categoria;
import tp.model.service.IManterCategoria;
import tp.util.db.exception.NegocioException;
import tp.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterCategoria implements IManterCategoria {
    private ICategoriaDAO categoriaDAO;
    
    public ManterCategoria() {
        categoriaDAO = new CategoriaDAO();
    }
    
    @Override
    public Long cadastrar(Categoria categoria) throws PersistenciaException, NegocioException {
        if((categoria.getNome() == null) || (categoria.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");

        Long result = categoriaDAO.inserir(categoria);
        return result;
    }

    @Override
    public boolean alterar(Categoria categoria) throws PersistenciaException, NegocioException {
        if((categoria.getNome() == null) || (categoria.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");

        boolean result = categoriaDAO.atualizar(categoria);
        return result;
    }

    @Override
    public boolean excluir(Categoria categoria) throws PersistenciaException, NegocioException {
        boolean result = categoriaDAO.delete(categoria);
        return result;
    }

    @Override
    public List<Categoria> pesquisarTodos() throws PersistenciaException {
        List<Categoria> result = categoriaDAO.listarTodos();
        return result;
    }

    @Override
    public Categoria pesquisarPorId(Long id) throws PersistenciaException {
        Categoria result = categoriaDAO.consultarPorId(id);
        return result;       
    }
}

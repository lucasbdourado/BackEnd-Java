package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Venda;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repository.generic.GenericDAO;

public class VendaExclusaoDAO extends GenericDAO<Venda, Long> implements IVendaDAO{
    public VendaExclusaoDAO() {
        super(Venda.class);
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public Venda consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }
}

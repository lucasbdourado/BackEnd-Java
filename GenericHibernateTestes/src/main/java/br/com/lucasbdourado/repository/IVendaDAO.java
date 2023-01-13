package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.repository.generic.IGenericDAO;
import br.com.lucasbdourado.domain.Venda;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long>{
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	public Venda consultarComCollection(Long id);
}

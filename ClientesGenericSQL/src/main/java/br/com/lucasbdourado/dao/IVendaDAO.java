/**
 * 
 */
package br.com.lucasbdourado.dao;

import br.com.lucasbdourado.dao.generic.IGenericDAO;
import br.com.lucasbdourado.domain.Venda;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}

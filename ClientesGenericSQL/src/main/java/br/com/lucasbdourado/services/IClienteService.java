/**
 * 
 */
package br.com.lucasbdourado.services;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}

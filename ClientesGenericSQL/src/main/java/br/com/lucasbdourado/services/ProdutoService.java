/**
 * 
 */
package br.com.lucasbdourado.services;

import br.com.lucasbdourado.dao.IProdutoDAO;
import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}

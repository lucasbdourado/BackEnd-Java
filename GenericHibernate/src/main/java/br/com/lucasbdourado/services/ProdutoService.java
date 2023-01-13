package br.com.lucasbdourado.services;

import br.com.lucasbdourado.repository.IProdutoDAO;
import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
package br.com.lucasbdourado.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.repository.generic.GenericDAO;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}
}

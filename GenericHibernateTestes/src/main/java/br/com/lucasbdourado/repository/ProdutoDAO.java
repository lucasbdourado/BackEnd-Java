package br.com.lucasbdourado.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.repository.generic.GenericDAO;
import br.com.lucasbdourado.repository.generic.GenericDB1DAO;

public class ProdutoDAO extends GenericDB1DAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}
}

package br.com.lucasbdourado.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.repository.generic.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}
}

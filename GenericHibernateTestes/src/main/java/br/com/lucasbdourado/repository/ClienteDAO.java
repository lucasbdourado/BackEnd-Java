package br.com.lucasbdourado.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.repository.generic.GenericDAO;
import br.com.lucasbdourado.repository.generic.GenericDB1DAO;

public class ClienteDAO extends GenericDB1DAO<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}
}

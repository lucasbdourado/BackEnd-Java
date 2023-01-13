package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.repository.generic.GenericDB2DAO;

public class ClienteDB2DAO extends GenericDB2DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDB2DAO() {
        super(Cliente.class);
    }

}

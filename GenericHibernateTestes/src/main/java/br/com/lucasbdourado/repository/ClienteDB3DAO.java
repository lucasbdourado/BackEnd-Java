package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.domain.Cliente2;
import br.com.lucasbdourado.repository.generic.GenericDB3DAO;

public class ClienteDB3DAO extends GenericDB3DAO<Cliente2, Long> implements IClienteDAO<Cliente2> {

    public ClienteDB3DAO() {
        super(Cliente2.class);
    }

}

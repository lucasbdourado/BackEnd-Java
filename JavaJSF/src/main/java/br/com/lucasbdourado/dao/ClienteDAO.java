package br.com.lucasbdourado.dao;

import br.com.lucasbdourado.dao.generic.GenericDAO;
import br.com.lucasbdourado.domain.Cliente;
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

}

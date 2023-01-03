package br.com.projectcliente.dao;

import br.com.projectcliente.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean create(Cliente cliente);

    public Boolean delete(Long cpf);

    public void update(Cliente cliente);

    public Cliente query(Long cpf);

    public Collection<Cliente> queryAll();
}

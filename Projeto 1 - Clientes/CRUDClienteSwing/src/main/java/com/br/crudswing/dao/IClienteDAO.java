package com.br.crudswing.dao;

import com.br.crudswing.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean create(Cliente cliente);

    public Boolean delete(Long cpf);

    public void update(Cliente cliente);

    public Cliente query(Long cpf);

    public Collection<Cliente> queryAll();
}

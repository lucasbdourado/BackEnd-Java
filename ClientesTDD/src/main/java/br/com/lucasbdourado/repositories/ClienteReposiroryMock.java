package br.com.lucasbdourado.repositories;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;

public class ClienteReposiroryMock implements IClienteRepository {
    @Override
    public Boolean create(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void delete(Long valor) {

    }

    @Override
    public void update(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente query(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }
}

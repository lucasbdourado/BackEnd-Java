package br.com.lucasbdourado.services;

import br.com.lucasbdourado.domain.Cliente;

public class ClienteServiceMock implements IClienteService {
    @Override
    public Boolean create(Cliente cliente) {
        return true;
    }

    @Override
    public Cliente selectCPF(Long cpf) {
        return null;
    }

    @Override
    public void delete(Long cpf) {

    }

    @Override
    public void update(Long cpf) {

    }
}

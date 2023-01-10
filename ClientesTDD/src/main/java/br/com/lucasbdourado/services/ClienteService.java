package br.com.lucasbdourado.services;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repositories.ClienteRepository;
import br.com.lucasbdourado.repositories.IClienteRepository;

public class ClienteService implements IClienteService{

    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository){
        this.clienteRepository = new ClienteRepository();
    }
    @Override
    public Boolean create(Cliente cliente) throws TipoChaveNaoEncontradaException {

        return clienteRepository.create(cliente);
    }

    @Override
    public Cliente selectCPF(Long cpf) {
        return clienteRepository.query(cpf);
    }

    @Override
    public void delete(Long cpf) {

    }

    @Override
    public void update(Long cpf) {

    }
}

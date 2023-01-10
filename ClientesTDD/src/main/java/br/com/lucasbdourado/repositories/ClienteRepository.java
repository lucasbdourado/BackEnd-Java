package br.com.lucasbdourado.repositories;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.domain.Persistent;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repositories.generics.GenericRepository;

public class ClienteRepository extends GenericRepository<Cliente> implements IClienteRepository {

    public ClienteRepository(){
        super();
    }
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void updateData(Cliente entity, Cliente entityCreated) {

    }



}

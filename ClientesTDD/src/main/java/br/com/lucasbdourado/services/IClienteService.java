package br.com.lucasbdourado.services;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean create(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente selectCPF(Long cpf);

    void delete(Long cpf);

    void update(Long cpf);
}

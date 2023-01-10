package br.com.lucasbdourado.services.generics;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;

public interface IGenericService<T> {
    Boolean create(T entity) throws TipoChaveNaoEncontradaException;

    Cliente selectCPF(Long cpf);

    void delete(Long cpf);

    void update(T entity) throws TipoChaveNaoEncontradaException;
}

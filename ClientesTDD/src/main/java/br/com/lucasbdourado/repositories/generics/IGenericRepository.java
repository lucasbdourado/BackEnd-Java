package br.com.lucasbdourado.repositories.generics;

import br.com.lucasbdourado.domain.Persistent;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;

public interface IGenericRepository <T extends Persistent>{
    public Boolean create(T entity) throws TipoChaveNaoEncontradaException;

    public void delete(Long valor);

    public void update(T entity) throws TipoChaveNaoEncontradaException;

    public T query(Long valor);
}

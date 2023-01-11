package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.domain.Produto;

import java.util.List;

public interface IClienteRepository {

    Integer create(Cliente cliente) throws Exception;

    Cliente query(String cod) throws Exception;

    Integer delete(Cliente cliente) throws Exception;

    List<Cliente> queryAll() throws Exception;

    Integer update(Cliente cliente) throws Exception;
}

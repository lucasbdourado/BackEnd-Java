package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.domain.Produto;

import java.util.List;

public interface IProdutoRepository {
    Integer create(Produto produto) throws Exception;

    Produto query(String cod) throws Exception;

    Integer delete(Produto produto) throws Exception;

    List<Produto> queryAll() throws Exception;

    Integer update(Produto produto) throws Exception;
}

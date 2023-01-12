package br.com.lucasbdourado.dao;

import br.com.lucasbdourado.domain.Carro;
import br.com.lucasbdourado.domain.Marca;

public interface ICarroDao {

    Carro create(Carro carro);

    Marca queryMarca(Carro carro);
}

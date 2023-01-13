package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.repository.generic.IGenericDAO;
import br.com.lucasbdourado.domain.Cliente;

public interface IClienteDAO<T extends Persistente> extends IGenericDAO<T, Long>{

}

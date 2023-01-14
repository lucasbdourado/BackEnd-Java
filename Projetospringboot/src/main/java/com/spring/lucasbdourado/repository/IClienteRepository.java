package com.spring.lucasbdourado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.lucasbdourado.domain.Cliente;
@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}

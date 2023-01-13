package br.com.lucasbdourado.repository.generic;

import br.com.lucasbdourado.repository.Persistente;

import java.io.Serializable;

public abstract class GenericDB3DAO <T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {
    public GenericDB3DAO(Class<T> persistenteClass) {
        super(persistenteClass, "hibernate-mysql");
    }

}

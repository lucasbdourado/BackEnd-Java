package br.com.lucasbdourado.repository.generic;

import br.com.lucasbdourado.repository.Persistente;

import java.io.Serializable;

public abstract class GenericDB2DAO <T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {
    public GenericDB2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "hibernate-postgres-2");
    }

}

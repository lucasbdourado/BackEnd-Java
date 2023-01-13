package br.com.lucasbdourado.repository.generic;

import br.com.lucasbdourado.repository.Persistente;

import java.io.Serializable;

public abstract class GenericDB1DAO <T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {
        public GenericDB1DAO(Class<T> persistenteClass) {
            super(persistenteClass, "hibernate-postgres-1");
        }
}

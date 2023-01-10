package br.com.lucasbdourado.services.generics;

public abstract class GenericService<T> implements IGenericService<T>{

    private T genericRepsitory;

    public GenericService(T genericRepsitory) {
        this.genericRepsitory = genericRepsitory;
    }


}

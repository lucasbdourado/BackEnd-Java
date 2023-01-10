package br.com.lucasbdourado.repositories.generics;

import br.com.lucasbdourado.anotacao.TipoChave;
import br.com.lucasbdourado.domain.Persistent;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class GenericRepository <T extends Persistent> implements IGenericRepository<T> {
    private SingletonMap singletonMap;
    public abstract Class<T> getTipoClasse();

    public abstract void updateData(T entity, T entityCreated);

    public GenericRepository(){
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException{
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for(Field field : fields){
            if (field.isAnnotationPresent(TipoChave.class)){
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMethod = tipoChave.value();
                try{
                    Method method = entity.getClass().getMethod(nomeMethod);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto "+ entity.getClass() + " não encontrada");
                }
            }
        }
        if (returnValue == null){
            String msg = "Chave principal do objeto "+ entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****");
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean create(T entity) throws TipoChaveNaoEncontradaException{
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);
        if ((mapaInterno).containsKey(chave)){
            return false;
        }
        mapaInterno.put(chave,entity);
        return true;
    }

    @Override
    public void delete(Long valor) {
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(valor);
        if (objetoCadastrado != null){
            mapaInterno.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public void update(T entity) throws TipoChaveNaoEncontradaException{
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);
        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null){
            updateData(entity, objetoCadastrado);
        }
    }

    @Override
    public T query(Long valor){
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        return (T) mapaInterno.values();
    }

    public Collection<T> queryAll(){
        Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.values();
    }
}

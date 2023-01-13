/**
 * 
 */
package br.com.lucasbdourado.services.generic;

import br.com.lucasbdourado.dao.Persistente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author rodrigo.pires
 *
 */
public interface IGenericService <T extends Persistente, E extends Serializable> {
	
	/**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     * @throws DAOException
     */
    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param valor chave única do dado a ser excluído
     * @throws DAOException
     */
    void excluir(E valor) throws DAOException;

    /**
     * Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     * @throws DAOException
     */
    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     * @throws DAOException
     */
    T consultar(E valor) throws DAOException;

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException
     */
    Collection<T> buscarTodos() throws DAOException;

}

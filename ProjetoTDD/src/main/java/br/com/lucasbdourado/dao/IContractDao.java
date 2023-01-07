package br.com.lucasbdourado.dao;

import br.com.lucasbdourado.Contract;

public interface IContractDao {
    void salvar();

    Contract query(int id);

    String delete(int id);

    String update(int id, int new_id);
}

package br.com.lucasbdourado.service;

import br.com.lucasbdourado.Contract;

public interface IContractService {

    String salvar();

    Contract query(int id);

    String delete(int id);

    String update(int contract_id, int new_id);
}

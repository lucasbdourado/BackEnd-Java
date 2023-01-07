package br.com.lucasbdourado.service;

import br.com.lucasbdourado.Contract;
import br.com.lucasbdourado.dao.IContractDao;
import br.com.lucasbdourado.service.IContractService;

public class ContractService implements IContractService {
    private IContractDao contractdao;

    public ContractService(IContractDao dao) {
        this.contractdao = dao;
    }

    @Override
    public String salvar() {
        contractdao.salvar();
        return "Sucesso";
    }

    @Override
    public Contract query(int id) {
        return contractdao.query(id);
    }

    @Override
    public String delete(int id) {
        return contractdao.delete(id);
    }

    public String update(int contract_id, int new_id) {
        return contractdao.update(contract_id, new_id);
    }
}

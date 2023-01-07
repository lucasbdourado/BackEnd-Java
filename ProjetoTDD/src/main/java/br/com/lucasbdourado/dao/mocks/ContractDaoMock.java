package br.com.lucasbdourado.dao.mocks;

import br.com.lucasbdourado.Contract;
import br.com.lucasbdourado.dao.IContractDao;

public class ContractDaoMock implements IContractDao {
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona sem o banco de dados");
    }

    @Override
    public Contract query(int id) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public String update(int id, int new_id) {
        return null;
    }
}

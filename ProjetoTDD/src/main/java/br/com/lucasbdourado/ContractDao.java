package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.IContractDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDao implements IContractDao {
    static Map<Integer,Contract> contracts = new HashMap<>();
    @Override
    public void salvar() {
        Contract contract = new Contract();
        contracts.put(contract.getId(), contract);
    }

    public Contract query(int id){
        boolean contractFound = contracts.containsKey(id);

        if (contractFound){
            return contracts.get(id);
        }
        return null;
    }

    @Override
    public String delete(int id) {
        boolean contractFound = contracts.containsKey(id);

        if(contractFound){
            contracts.remove(id, contractFound);

            return "Contrato Excluido com sucesso!";
        }

        return "Contrato não encontrado";
    }

    @Override
    public String update(int id, int new_id) {
        boolean contractFound = contracts.containsKey(id);

        if (contractFound){
            Contract contract = contracts.get(id);

            contract.changeId(new_id);

            return "Contrado editado com sucesso!";
        }
        return "Contrato não encontrado";
    }
}

package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.IContractDao;
import br.com.lucasbdourado.dao.mocks.ContractDaoMock;
import br.com.lucasbdourado.service.ContractService;
import br.com.lucasbdourado.service.IContractService;
import org.junit.Assert;
import org.junit.Test;

public class ContractServiceTest {

    @Test(expected = UnsupportedOperationException.class)
    public void salvarTest(){
        IContractDao dao = new ContractDaoMock();
        IContractService service = new ContractService(dao);
        String ret = service.salvar();
        Assert.assertNotEquals("Sucesso", ret);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void databaseError(){
        IContractDao dao = new ContractDaoMock();
        IContractService service = new ContractService(dao);
        String ret = service.salvar();
        Assert.assertEquals("Sucesso", ret);
    }

    @Test
    public void databaseQuery(){
        IContractDao dao = new ContractDao();
        IContractService service = new ContractService(dao);
        String contract = service.salvar();
        Contract ret = service.query(1);
        Assert.assertNotNull(ret);
    }

    @Test
    public void databaseUpdate(){
        IContractDao dao = new ContractDao();
        IContractService service = new ContractService(dao);
        Contract old = service.query(1);
        String ret = service.update(1, 2);
        Assert.assertEquals("Contrado editado com sucesso!", ret);
    }

    @Test
    public void databaseDelete(){
        IContractDao dao = new ContractDao();
        IContractService service = new ContractService(dao);
        String ret = service.delete(1);
        Assert.assertEquals("Contrato Excluido com sucesso!", ret);
    }
}

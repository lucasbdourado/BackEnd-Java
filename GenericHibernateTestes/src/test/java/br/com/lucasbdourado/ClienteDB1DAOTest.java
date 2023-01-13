package br.com.lucasbdourado;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.MaisDeUmRegistroException;
import br.com.lucasbdourado.exceptions.TableException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repository.ClienteDAO;
import br.com.lucasbdourado.repository.ClienteDB2DAO;
import br.com.lucasbdourado.repository.IClienteDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

public class ClienteDB1DAOTest {

    private IClienteDAO<Cliente> clienteDao;

    private IClienteDAO<Cliente> clienteDB2Dao;

    private Random rd;

    public ClienteDB1DAOTest() {
        this.clienteDao = new ClienteDAO();
        this.clienteDB2Dao = new ClienteDB2DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<Cliente> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Cliente cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        Cliente clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente cliente1 = criarCliente();
        Cliente retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        Assert.assertTrue(list != null);
        Assert.assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        Assert.assertTrue(list1 != null);
        Assert.assertTrue(list1.size() == 0);
    }

    private Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Lucas Dourado");
        cliente.setCidade("Santos");
        cliente.setEnd("Praia");
        cliente.setEstado("SP");
        cliente.setNumero(128);
        cliente.setTel(1399999999L);
        return cliente;
    }
}

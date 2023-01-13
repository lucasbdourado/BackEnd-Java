package br.com.lucasbdourado;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.lucasbdourado.repository.ClienteDAO;
import br.com.lucasbdourado.repository.IClienteDAO;
import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.MaisDeUmRegistroException;
import br.com.lucasbdourado.exceptions.TableException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;
public class ClienteDAOTest {

	private IClienteDAO clienteDao;

	private Random rd;

	public ClienteDAOTest() {
		this.clienteDao = new ClienteDAO();
		rd = new Random();
	}

	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
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

		clienteConsultado.setNome("Lucas Dourado");
		clienteDao.alterar(clienteConsultado);

		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Lucas Dourado", clienteAlterado.getNome());

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
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}

	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Lucas Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1399999999L);
		return cliente;
	}

}
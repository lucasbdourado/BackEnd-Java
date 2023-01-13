/**
 * 
 */
package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.ClienteDAO;
import br.com.lucasbdourado.dao.IClienteDAO;
import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.MaisDeUmRegistroException;
import br.com.lucasbdourado.exceptions.TableException;
import br.com.lucasbdourado.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	private final IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Lucas Dourado");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Lucas Dourado", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
		cliente.setCpf(11711511695L);
		cliente.setNome("Lucas");
		cliente.setNome("Dourado");
		cliente.setCidade("Santos");
		cliente.setEnd("Praia");
		cliente.setEstado("SP");
		cliente.setNumero(128);
		cliente.setTel(1399999999L);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}

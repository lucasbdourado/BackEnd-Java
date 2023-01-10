package br.com.lucasbdourado;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repositories.ClienteReposiroryMock;
import br.com.lucasbdourado.repositories.IClienteRepository;
import br.com.lucasbdourado.services.ClienteService;
import br.com.lucasbdourado.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteRepository clienteRepository = new ClienteReposiroryMock();
        clienteService = new ClienteService(clienteRepository);
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(11714596966L);
        cliente.setNome("Lucas");
        cliente.setPhone(47999491763L);
        cliente.setState("São Paulo");
        cliente.setCity("Santos");
        cliente.setStreet("Vila Belmiro");
        cliente.setNumber(128);

        salvarClient();
    }

    @Test
    public void queryClient(){

        Cliente queryCliente = clienteService.selectCPF(cliente.getCpf());

        Assert.assertNotNull(queryCliente);
    }

    @Test
    public void salvarClient() throws TipoChaveNaoEncontradaException {
       Boolean ret = clienteService.create(cliente);

       Assert.assertTrue(ret);
    }
    @Test
    public void deleteClient(){
        clienteService.delete(cliente.getCpf());
    }

    @Test
    public void updateClient(){
        cliente.setNome("Lucas Dourado");
        clienteService.update(cliente.getCpf());

        Assert.assertEquals("Lucas Dourado", cliente.getNome());
    }

}
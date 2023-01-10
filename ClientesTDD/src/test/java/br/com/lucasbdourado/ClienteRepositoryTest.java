package br.com.lucasbdourado;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exception.TipoChaveNaoEncontradaException;
import br.com.lucasbdourado.repositories.ClienteReposiroryMock;
import br.com.lucasbdourado.repositories.IClienteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteRepositoryTest {
    private IClienteRepository clienteRepository;
    private Cliente cliente;

    public ClienteRepositoryTest(){
        clienteRepository = new ClienteReposiroryMock();
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

        clienteRepository.create(cliente);
    }
    @Test
    public void queryClient(){

        Cliente queryCliente = clienteRepository.query(cliente.getCpf());

        Assert.assertNotNull(queryCliente);
    }

    @Test
    public void deleteClient(){
        clienteRepository.delete(cliente.getCpf());
    }
}

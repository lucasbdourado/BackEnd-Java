package br.com.lucasbdourado;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.repository.ClienteRepository;
import br.com.lucasbdourado.repository.IClienteRepository;
import br.com.lucasbdourado.repository.IProdutoRepository;
import br.com.lucasbdourado.repository.ProdutoRepository;
import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void createTest() throws Exception {
        IClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente = new Cliente();
        cliente.setCod("1");
        cliente.setNome("Lucas Dourado");

        Integer created = clienteRepository.create(cliente);
        Assert.assertTrue(created == 1);

        Cliente clienteBD = clienteRepository.query(cliente.getCod());
        Assert.assertNotNull(clienteBD);
        Assert.assertNotNull(clienteBD.getId());
        Assert.assertEquals(cliente.getCod(), clienteBD.getCod());
        Assert.assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer deleted = clienteRepository.delete(clienteBD);
    }

    @Test
    public void createTestProduct() throws Exception {
        IProdutoRepository produtoRepository = new ProdutoRepository();
        Produto produto = new Produto();
        produto.setCod("1");
        produto.setNome("Radio de pilha");
        produto.setPrice(22.5f);

        Integer created = produtoRepository.create(produto);
        Assert.assertTrue(created == 1);

        Produto produtoBD = produtoRepository.query(produto.getCod());
        Assert.assertNotNull(produtoBD);
        Assert.assertNotNull(produtoBD.getId());
        Assert.assertEquals(produto.getCod(), produtoBD.getCod());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());
        Assert.assertEquals(produto.getPrice(), produtoBD.getPrice());

        Integer deleted = produtoRepository.delete(produtoBD);
    }
}

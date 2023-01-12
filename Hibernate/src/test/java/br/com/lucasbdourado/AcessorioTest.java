package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.AcessorioDao;
import br.com.lucasbdourado.dao.IAcessorioDao;
import br.com.lucasbdourado.domain.Acessorio;
import org.junit.Assert;
import org.junit.Test;

public class AcessorioTest {
    private IAcessorioDao acessorioDao;

    public AcessorioTest(){
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void createTeste(){
        Acessorio acessorio = new Acessorio();
        acessorio.setAcessorio("Volante");
        acessorio = acessorioDao.create(acessorio);

        Assert.assertNotNull(acessorio);
        Assert.assertNotNull(acessorio.getId());
    }
}

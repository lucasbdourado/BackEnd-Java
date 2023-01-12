package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.*;
import br.com.lucasbdourado.domain.Acessorio;
import br.com.lucasbdourado.domain.Carro;
import br.com.lucasbdourado.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarroTest {
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest(){
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void createTest(){
            Marca marca = new Marca();
            marca.setNome("BMW");

            Carro carro = new Carro();
            carro.setModelo("X5");
            carro.setMarca(marca);

            Acessorio acessorio = new Acessorio();
            acessorio.setAcessorio("Volante");

            List<Carro> carros = new ArrayList<>();
            carros.add(carro);
            carro.addAcessorios(acessorio);
            marca.setCarros(carros);

            carroDao.create(carro);
            marcaDao.create(marca);

            Marca queryMarca = carroDao.queryMarca(carro);

            Assert.assertNotNull(queryMarca);
    }
}

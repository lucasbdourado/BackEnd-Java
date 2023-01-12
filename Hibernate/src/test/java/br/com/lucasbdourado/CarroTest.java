package br.com.lucasbdourado;

import br.com.lucasbdourado.dao.*;
import br.com.lucasbdourado.domain.Acessorio;
import br.com.lucasbdourado.domain.Carro;
import br.com.lucasbdourado.domain.Marca;
import org.junit.Test;

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
        Carro carro = new Carro();

    }
}

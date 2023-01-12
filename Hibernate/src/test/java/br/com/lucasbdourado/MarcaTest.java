package br.com.lucasbdourado;

import br.com.lucasbdourado.domain.Marca;
import org.junit.Test;

public class MarcaTest {

    @Test
    public void create(){
        Marca marca = new Marca();
        marca.setNome("Mercedes");

    }
}

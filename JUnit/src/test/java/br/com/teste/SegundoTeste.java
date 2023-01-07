package br.com.teste;

import org.junit.Assert;
import org.junit.Test;

public class SegundoTeste {
    @Test
    public void test3() {
        String nome = "Lucas";
        Assert.assertEquals("Lucas", nome);
    }
}

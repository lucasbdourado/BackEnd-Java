package br.com.teste;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

        @Test
        public void test() {
            String nome = "Lucas";
            Assert.assertEquals("Lucas", nome);
        }
        @Test
        public void testNotEquals() {
            String nome = "Lucas";
            Assert.assertNotEquals("Lucas2", nome);
        }
}

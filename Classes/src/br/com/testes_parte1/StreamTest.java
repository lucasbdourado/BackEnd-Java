package br.com.testes_parte1;

import br.com.stream.Tarefa;
import br.com.stream.classes.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StreamTest {
    List feminino = Tarefa.getPessoas();
    @Test
    public void test(){
        List<Pessoa> feminino = Tarefa.getPessoas();

        for (Pessoa feminina: feminino) {
            Assert.assertEquals("Feminino", feminina.getSexo());
        }
    }
}

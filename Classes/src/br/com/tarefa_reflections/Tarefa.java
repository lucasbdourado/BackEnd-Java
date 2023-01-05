package br.com.tarefa_reflections;

import br.com.tarefa_annotation.Tabela;

public class Tarefa {
    public static void main(String[] args) {
        Classe c1 = new Classe();
        System.out.println(c1.getClass().getDeclaredAnnotation(Tabela.class));
    }
}

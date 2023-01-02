package br.com.colecoes_parte_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Pessoa> masculino = new ArrayList<Pessoa>();
        List<Pessoa> feminino = new ArrayList<Pessoa>();

        for(int i = 1; i<=5 ; i++) {
            Pessoa pessoas = new Pessoa("Pessoa" + i,"Masculino");

            masculino.add(pessoas);
        }

        for(int i = 1; i<=5 ; i++) {
            Pessoa pessoas = new Pessoa("Pessoa" + i,"Feminino");

            feminino.add(pessoas);
        }

        System.out.println(feminino);

        String text = sc.nextLine();

        String[] textoSeparado = text.split(",");
        Pessoa pessoa = new Pessoa(textoSeparado[0], textoSeparado[1]);

        if(pessoa.compareTo(feminino.get(0)) == 0){
            feminino.add(pessoa);
        }else if(pessoa.compareTo(masculino.get(0)) == 0){
            masculino.add(pessoa);
        }else{
            System.out.println("Digite o Sexo corretamente, utilizando somente Masculino e Feminino");
        }

        System.out.println("**** Arrays ****");

        System.out.println("Masculino:");
        for(int i = 0; i<masculino.size() ; i++) {
            System.out.println(masculino.get(i).getNome() + " , " + masculino.get(i).getSexo());
        }

        System.out.println("Feminino:");
        for(int i = 0; i<feminino.size() ; i++) {
            System.out.println(feminino.get(i).getNome() + " , " + feminino.get(i).getSexo());
        }
    }
}

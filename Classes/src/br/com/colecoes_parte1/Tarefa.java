package br.com.colecoes_parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tarefa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();


        for(int i = 1; i<=5 ; i++) {
            Pessoa pessoa = new Pessoa("Pessoa" + i,"Feminino");

            pessoas.add(pessoa);
        }

        String text = sc.nextLine();

        String[] textoSeparado = text.split(",");
        Pessoa pessoa = new Pessoa(textoSeparado[0], textoSeparado[1]);

        pessoas.add(pessoa);

        System.out.println("**** Arrays ****");

        System.out.println("Pessoas sem ordenação:");
        for(int i = 0; i<pessoas.size() ; i++) {
            System.out.println(pessoas.get(i).getNome() + " , " + pessoas.get(i).getSexo());
        }

        Collections.sort(pessoas);

        System.out.println("Pessoas com ordenação:");
        for(int i = 0; i<pessoas.size() ; i++) {
            System.out.println(pessoas.get(i).getNome() + " , " + pessoas.get(i).getSexo());
        }
    }
}

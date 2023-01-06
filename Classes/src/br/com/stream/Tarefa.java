package br.com.stream;

import br.com.stream.classes.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Tarefa {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        List<Pessoa> feminino = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);

            String person = sc.nextLine();

            String[] data = person.split(",");

            pessoas.add(new Pessoa(data[0], data[1].trim()));
        }

        pessoas.stream().filter(pessoa -> pessoa.getSexo().contains("F")).forEach(p -> {
            feminino.add(p);
        });


        for (Pessoa feminina: feminino) {
            System.out.println("Nome: " + feminina.getNome() + ", Sexo: " + feminina.getSexo());
        }
    }
}

package br.com.stream;

import br.com.stream.classes.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Tarefa {
    static List<Pessoa> pessoas = new ArrayList<>();
    static List<Pessoa> feminino = new ArrayList<>();
    public static List main(String[] args) {



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
        return feminino;
    }

    public static List getPessoas(){
        pessoas.add(new Pessoa("Hugo", "Masculino"));
        pessoas.add(new Pessoa("Fernanda", "Feminino"));
        pessoas.add(new Pessoa("Carla", "Feminino"));
        pessoas.add(new Pessoa("Michel", "Masculino"));
        pessoas.add(new Pessoa("Roger", "Masculino"));
        pessoas.add(new Pessoa("Fernanda", "Feminino"));
        pessoas.add(new Pessoa("Maria", "Feminino"));

        return feminino;
    }
}

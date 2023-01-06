package br.com.stream.classes;

public class Pessoa {

    String sexo;
    String nome;

    public Pessoa(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNome() {
        return nome;
    }
}

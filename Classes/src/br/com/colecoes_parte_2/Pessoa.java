package br.com.colecoes_parte_2;

public class Pessoa implements Comparable<Pessoa>{

    private String nome;
    private String sexo;


    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.sexo.compareTo(o.getSexo());
    }
}

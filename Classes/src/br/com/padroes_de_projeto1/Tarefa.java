package br.com.padroes_de_projeto1;

public class Tarefa {

    public static void main(String[] args) {
        Piloto piloto1 = new Piloto("Red Bull");
        Fabrica fabrica = new EquipeF1();
        Car carro1 = fabrica.create(piloto1.getEquipe());
        carro1.testes(piloto1.getEquipe());
    }
}

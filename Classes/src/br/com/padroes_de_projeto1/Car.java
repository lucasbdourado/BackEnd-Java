package br.com.padroes_de_projeto1;

public class Car {

    private int portas = 2;
    private int rodas = 4;
    private String motor;

    public Car(String motor){
        this.motor = motor;
    }

    public void createMotor() {
        System.out.println("Criando motor "+ motor);
    }
    public void createPortas(){
        for (int i = 1; i <= portas; i++) {
            System.out.println("Criando Porta "+ i);
        }
    }
    public void createRodas(){
        for (int i = 1; i <= rodas; i++) {
            System.out.println("Criando Roda "+ i);
        }
    }
    public void createCarroceria(){
        System.out.println("Criando Carroceria");
    }
    public void testes(String equipe){
        System.out.println("Testando Carro da " + equipe + "...");
        System.out.println("Teste finalizado!");
    }

}

package br.com.generics;

public abstract class Car {
    private int rodas = 4;
    private String marca;
    public Car(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}

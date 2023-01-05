package br.com.generics;

import br.com.tarefa_classes.Carro;

import java.util.ArrayList;
import java.util.List;

public class Tarefa {

    public static void main(String[] args) {
        Car c1 = new Ferrari("Ferrari");
        Car c2 = new Ferrari("Ferrari");
        Car c3 = new Audi("Audi");
        Car c4 = new Audi("Audi");
        Car c5 = new Mercedes("Mercedes");
        Car c6 = new Mercedes("Mercedes");

        List<Car> lista = new ArrayList<>();

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        lista.add(c5);
        lista.add(c6);

        print(lista);
    }

    public static void print(List<? extends Car> list){
        for (Car car : list){
            System.out.println(car.getMarca());
        }
    }
}

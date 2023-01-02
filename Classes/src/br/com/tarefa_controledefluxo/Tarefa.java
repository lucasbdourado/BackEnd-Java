package br.com.tarefa_controledefluxo;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa {

    public static void main(String[] args) {
        Media media = new Media();

        for (int i=1; i<=4; i++){
            System.out.println("Digite a nota "+ i);
            Scanner x = new Scanner(System.in);
            int nota = x.nextInt();

            media.addNota(nota);
        }

        System.out.println("**** Média ****");
        float medias = media.getMedia();

        System.out.println(medias);
    }
}

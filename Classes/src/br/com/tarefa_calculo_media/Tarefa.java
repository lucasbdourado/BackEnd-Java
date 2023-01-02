package br.com.tarefa_calculo_media;

public class Tarefa {

    public static void main(String[] args) {
        Media media = new Media();
        media.setNota1(8);
        media.setNota2(8);
        media.setNota3(8);
        media.setNota4(9);

        media.culcularMedia();
    }
}

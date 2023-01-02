package br.com.tarefa_controledefluxo;

import java.util.ArrayList;
import java.util.List;

public class Media {
    List<Integer> notas = new ArrayList<Integer>();

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList notas) {
        this.notas = notas;
    }

    public void addNota(int nota) {
        this.notas.add(nota);
    }

    public float getMedia(){
        float media = 0;

        for (int i = 0; i<notas.size(); i++){
            media = media + notas.get(i);
        }

        media = media / 4;

        if(media>=7){
            System.out.println("Você foi aprovado!");
        }else{
            System.out.println("Você foi reprovado!");
        }
        return media;
    }

}

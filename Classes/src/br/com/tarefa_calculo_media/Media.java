package br.com.tarefa_calculo_media;

public class Media {
    private float nota1 = 0;
    private float nota2 = 0;
    private float nota3 = 0;
    private float nota4 = 0;

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public void culcularMedia(){
        if(nota1 > 0 && nota2 > 0 && nota3 > 0 && nota4 > 0){
            float media;

            media = (nota1+nota2+nota3+nota4) / 4;

            System.out.println("A Média é: " + media);
        }else{
            System.out.println("Você deve informar todas as notas para calcular a média");
        }
    }
}

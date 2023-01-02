package br.com.tarefa_classes;

/**
 * @author  Lucas Barbosa Dourado
 * @version : 1.0.0
 */
public class Carro {
    private boolean ligado;
    private boolean farol;

    private float volante;

    private boolean embreagem;
    private float velocidade;

    private int marcha;

    public float getVelocidade() {
        return velocidade;
    }
    /**
     * @param velocidade : Float de Velocidade
     */
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }
    /**
     * @param marcha : Int de Velocidade
     */
    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public boolean isEmbreagem() {
        return embreagem;
    }
    /**
     * @param embreagem : Sendo verdadeiro ou falso para embreagem
     */
    public void setEmbreagem(boolean embreagem) {
        this.embreagem = embreagem;
    }

    public boolean isLigado() {
        return ligado;
    }

    /**
     * @param ligado : Sendo verdadeiro ou falso para se o carro está ou não ligado
     */
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isFarol() {
        return farol;
    }

    public float getVolante() {
        return volante;
    }

    /**
     * @param volante : Sendo a quantidade em graus que o volante será virado
     */
    public void setVolante(float volante) {
        this.volante = volante;
    }

    /**
     * @param farol : Sendo true ou false para ligar ou desligar carro
     */
    public void setFarol(boolean farol) {
        this.farol = farol;
    }

    /**
     * @param marcha : Sendo o valor da marcha para ser trocada
     */
    public void trocarMarcha(int marcha){
        if(isEmbreagem()){
            setMarcha(marcha);
            System.out.println("Você trocou para "+ marcha +" marcha!");
        }else{
            System.out.println("Você deve acionar a embreagem para trocar de marcha!");
        }
    }

    public void ligarfarol(){
        if(isFarol()){
            System.out.println("O Farol ja está ligado!");
        }else{
            setFarol(true);
            System.out.println("Você ligou o farol do Carro!");
        }
    }

    public void ligarCarro(){
        if(isLigado()){
            System.out.println("O Carro ja está ligado!");
        }else{
            setLigado(true);
            System.out.println("Você ligou o carro!");
        }
    }

    public void desligarCarro(){
        if(!(isLigado())){
            System.out.println("O Carro ja está desligado!");
        }else{
            setLigado(false);
            System.out.println("Você desligou o carro!");
        }
    }

    public void desligarFarol(){
        if(!(isFarol())){
            System.out.println("O Farol ja está desligado!");
        }else{
            setFarol(false);
            System.out.println("Você desligou o farol!");
        }
    }

    public void acionarEmbreagem(){
        if(isEmbreagem()){
            System.out.println("A Embreagem ja está acionada!");
        }else{
            setEmbreagem(true);
            System.out.println("Você acionou a embreagem!");
        }
    }
}

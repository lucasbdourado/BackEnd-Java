package br.com.lucasbdourado;

public class Contract {
    private int id = 0;

    Contract(){
        this.id = id;
        id++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void changeId(int id){
        if(id>this.id){
            setId(id);
        }
    }
}

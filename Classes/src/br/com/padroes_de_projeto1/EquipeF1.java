package br.com.factory;

public class EquipeF1 extends Fabrica {

    @Override
    Car retrieveCar(String requestedModel) {
        switch (requestedModel) {
            case "Ferrari":
                return new Ferrari("Marea Turbo");
            case "Mercedes":
                return new Mercedes("Mercedes");
            case "Red Bull":
                return new RedBull("Honda");
            default:
                System.out.println("Essa equipe não está no grid");
                return null;
        }
    }
}

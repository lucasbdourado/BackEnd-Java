package br.com.factory;

public abstract class Fabrica {

    public Car create(String requestedModel){
        Car car = retrieveCar(requestedModel);
        car = createCar(car);
        return car;
    }

    private Car createCar(Car car) {
        car.createMotor();
        car.createPortas();
        car.createRodas();
        car.createCarroceria();

        return car;
    }

    abstract Car retrieveCar(String requestedModel);
}

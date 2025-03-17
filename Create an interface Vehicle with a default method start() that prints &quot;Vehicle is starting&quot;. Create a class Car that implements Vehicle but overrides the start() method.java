interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting with engine roar");
    }
}

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
    }
}

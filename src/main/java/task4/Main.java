package task4;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();
        Car[] cars = new Car[10];
        for (int i = 0; i < 10; i++) {
            cars[i] = new Car(i+1, road);
        }
        for(Car car: cars){
            car.start();
        }
        for(Car car: cars){
            try {
                car.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        road.valueSort();
    }
}

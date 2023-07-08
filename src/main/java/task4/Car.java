package task4;

import java.util.Random;

public class Car extends Thread {
    private int number;
    private Random random = new Random();
    private Road road;
    private int time;
    Car(int number, Road road){
        this.number = number;
        this.road = road;
    }

    @Override
    public void run() {
        System.out.println("Car " + number + " preparing to race");
        try {
            Thread.sleep(random.nextInt(4001)+1000);
            //System.out.println("Car " + number + " ready to start");
            road.getStart().countDown();
            System.out.println("Car " + number + " started");
            road.getStart().await();
           // System.out.println("Car " + number + " started");

            System.out.println("Car " + number + " ride normal road");
            int t = random.nextInt(4001)+1000;
            time += t;
            Thread.sleep(t);

            road.getTunnel().acquire();
            System.out.println("Car " + number + " in tunnel");
            t = random.nextInt(4001)+1000;
            time += t;
            Thread.sleep(t);
            road.getTunnel().release();

            System.out.println("Car " + number + " ride normal road");
            t = random.nextInt(4001)+1000;
            time += t;
            Thread.sleep(t);

            System.out.println("Car " + number + " finished");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        road.setRating(number, time);

    }

    /*
    prepare
    sleep
    start
    ride
    sleep
    tonel
    sleep
    ride
    sleep
    finish
     */
}

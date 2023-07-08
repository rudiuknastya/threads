package synchronization;

public class ExampleThread implements Runnable{
    SynchronizationExample synchronizationExample;
    int number;

    public ExampleThread(SynchronizationExample synchronizationExample, int number) {
        this.synchronizationExample = synchronizationExample;
        this.number = number;
    }

    @Override
    public void run() {
        synchronizationExample.addToNumber1(1, number);
        synchronizationExample.addToNumber2(2, number);
        //synchronizationExample.addToNumber2(2, number);
        synchronizationExample.addToNumber3(3, number);
        synchronizationExample.addToNumber4(4, number);
        System.out.println("Thread"+ number+ " get Number4: "+synchronizationExample.getNumber4());
    }
}

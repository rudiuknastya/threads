package threadCreation;

public class ThreadToInterrupt extends Thread{
    @Override
    public void run() {
        int i = 0;
        while(!Thread.interrupted()) {
            System.out.println(i);
            i++;
        }
    }
}

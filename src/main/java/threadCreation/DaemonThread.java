package threadCreation;

public class DaemonThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Do something");
        }
    }
}

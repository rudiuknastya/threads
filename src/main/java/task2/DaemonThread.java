package task2;

import java.util.concurrent.Future;

public class DaemonThread extends Thread{
    Future<String> future;
    DaemonThread(Future<String> future){
        this.future = future;
    }
    @Override
    public void run() {
        while (!future.isDone()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
    }
}

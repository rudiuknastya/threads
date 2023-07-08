package task2;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Sandy", "Julia", "Sam", "Gabby", "Linda");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        String s = scanner.nextLine();
        int number = Integer.parseInt(s);

        WorkingThread workingThread = new WorkingThread(names, number);
        Future<String> future = executorService.submit(workingThread);
        DaemonThread daemonThread = new DaemonThread(future);
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            System.out.print(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}

package synchronization;

import java.util.concurrent.*;

public class Main {
    public static void atomicExample(){
        AtomicExample atomicExample = new AtomicExample();
        Runnable plus = ()->{
            for (int i = 0; i < 10000; i++) {
                atomicExample.atomicIncr();
            }
        };
        Thread[] plusThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            plusThreads[i] = new Thread(plus);
        }
        for(int i = 0; i < 5; i++){
            plusThreads[i].start();
        }
        for(int i = 0; i < 5; i++){
            try {
                plusThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(atomicExample.count);
    }

    public static void nonAtomicExample(){
        AtomicExample atomicExample = new AtomicExample();
        Runnable plus = ()->{
            for (int i = 0; i < 10000; i++) {
                atomicExample.nonAtomicIncr();
            }
        };

        Thread[] plusThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            plusThreads[i] = new Thread(plus);
        }
        for(int i = 0; i < 5; i++){
            plusThreads[i].start();
        }
        for(int i = 0; i < 5; i++){
            try {
                plusThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(atomicExample.c);
    }

    public static void synchronizationExample(){
        SynchronizationExample synchronizationExample = new SynchronizationExample();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
           service.execute(new ExampleThread(synchronizationExample,i));
        }
        service.shutdown();
    }

    public static void safeCollections(){
        SafeCollections safeCollections = new SafeCollections();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                        safeCollections.workWithList();
                        safeCollections.workWithSet();
                    }
            );
        }
        service.shutdown();
    }
    public static void main(String[] args) {
        //atomicExample();
        //nonAtomicExample();
        //synchronizationExample();
        safeCollections();
    }


}

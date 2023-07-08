package synchronization;

import java.util.concurrent.locks.*;

public class SynchronizationExample {
    private Lock reentrantLock = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();
    private int number1 = 1;
    private Integer number2 = 1;
    private Object object = new Object();
    private int number3 = 1;
    private int number4 = 1;
    public synchronized void addToNumber1(int n, int threadNumber){
        number1 += n;
        System.out.println("Thread "+threadNumber+" add to number1: "+number1 );
    }
    public void addToNumber2(int n, int threadNumber){
        synchronized (object){
            number2 += n;
            System.out.println("Thread "+threadNumber+" add to Number2: "+number2 );
        }
    }
    public void addToNumber3(int n, int threadNumber){
        reentrantLock.lock();
        try {
            number3 += n;
            System.out.println("Thread "+threadNumber+" add to Number3: "+number3);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void addToNumber4(int n, int threadNumber){
        writeLock.lock();
        try {
            number4 += n;
            System.out.println("Thread "+threadNumber+" add to Number4: "+number4 );
        } finally {
            writeLock.unlock();
        }

    }

    public int getNumber4(){
        readLock.lock();
        try {
            return number4;
        } finally{
            readLock.unlock();
        }
    }
}

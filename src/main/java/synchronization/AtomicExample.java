package synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    int c = 0;
    AtomicInteger count = new AtomicInteger();
    public void nonAtomicIncr(){
            c++;
    }
    public void atomicIncr(){
        count.incrementAndGet();
    }

    public void atomicIncrImpl() {
        int current, next;
        do {
            current = count.get();
            next = current + 1;
        } while (!count.compareAndSet(current, next));
    }
}

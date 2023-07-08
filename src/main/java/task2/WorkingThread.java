package task2;

import java.util.List;
import java.util.concurrent.Callable;

public class WorkingThread implements Callable<String> {
    List<String> names;
    int index;

    public WorkingThread(List<String> names, Integer index) {
        this.names = names;
        this.index = index;
    }

    @Override
    public String call() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return names.get(index);
    }
}

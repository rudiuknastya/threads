package task4;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Road {
    private Semaphore tunnel = new Semaphore(3);
    private CountDownLatch start = new CountDownLatch(10);
    private ConcurrentHashMap<Integer, Integer> rating = new ConcurrentHashMap<>();
    public void setRating(int number, int time){
        rating.put(number, time);
    }
    public Semaphore getTunnel() {
        return tunnel;
    }

    public CountDownLatch getStart() {
        return start;
    }

    public void valueSort() {
        Comparator<Integer> valueComparator = new Comparator<Integer>() {

            public int compare(Integer k1, Integer k2)
            {
                int comp = rating.get(k1).compareTo(
                        rating.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        Map<Integer, Integer> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(rating);
        Iterator<Map.Entry<Integer, Integer>> iterator = sorted.entrySet().iterator();
        int i = 1;
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> car = iterator.next();
            System.out.println(i+" place - Car "+car.getKey()+ " Time: "+ car.getValue());
            i++;
        }

    }

}

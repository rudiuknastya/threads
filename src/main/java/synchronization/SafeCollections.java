package synchronization;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeCollections {
    Set<String> letters = Collections.synchronizedSet(new TreeSet<>());
    CopyOnWriteArrayList<String> animals = new CopyOnWriteArrayList<>();
    public void workWithSet(){
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");

        synchronized (letters){
            Iterator<String> iterator = letters.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    public void workWithList(){
        animals.add("Dog");
        animals.add("Rabbit");
        animals.add("Horse");
        Iterator<String> iterator = animals.iterator();
        animals.add("Panda");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

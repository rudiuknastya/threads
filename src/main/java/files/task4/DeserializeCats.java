package files.task4;

import java.io.*;
import java.util.*;

public class DeserializeCats {
    public static void main(String[] args) {
        List<Cat> cats;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cats.txt"))) {
                cats = (List<Cat>)inputStream.readObject();
                for(Cat cat: cats) {
                    System.out.println(cat.getName());
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

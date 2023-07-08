package files.task4;

import java.io.*;
import java.util.*;

public class SerializeCats {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Мурчик","Бенгальська",1));
        cats.add(new Cat("Боб","Бомбейська",3));
        cats.add(new Cat("Обама","Сфінкс",2));
        cats.add(new Cat("Сніжинка","Кімрійська",4));
        cats.add(new Cat("Вася","Бірманська",6));
        try(ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream("cats.txt"))) {
                outputStream.writeObject(cats);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

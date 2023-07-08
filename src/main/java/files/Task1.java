package files;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Enter word:");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        File dir = new File("C:\\Users\\Anastassia\\eclipse-workspace\\Threads\\src\\main\\folder1");
        try {
            Stream<Path> walkStream = Files.walk(dir.toPath());
            walkStream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().contains(word))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

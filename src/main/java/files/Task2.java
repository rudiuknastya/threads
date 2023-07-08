package files;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void write(){
        System.out.println("Enter names");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split(" ");
        try(FileWriter fileWriter = new FileWriter("task2.txt")) {
            for(String name: names) {
                fileWriter.write(name+"\r");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read(){
        String s = "";
        File file = new File("task2.txt");
        try(Reader reader = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            String fileContent = new String(chars);
            String[] names = fileContent.split("\r");
            Arrays.stream(names).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //write();
        read();
    }
}

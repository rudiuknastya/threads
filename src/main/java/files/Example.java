package files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example {
    public static void buffer(){
        String [] greeting = {"Hi. ", "How ","are ", "you","?"};
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Write to file! \n");
            for(String g: greeting){
                writer.write(g);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void file() {
        try (FileWriter fileWriter = new FileWriter("file.txt")) {
            fileWriter.write("file writer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fileReader = new FileReader("file.txt")) {
            int content;
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileStream(){
        String str = "Hello";
        try(FileOutputStream outputStream = new FileOutputStream("file.txt")) {
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileInputStream inputStream = new FileInputStream("file.txt")) {
            int i;
            while((i=inputStream.read())!=-1){
                System.out.print((char)i);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void files(){
        Path fileName = Path.of("file.txt");
        try {
            Files.writeString(fileName, "text");
            String file_content = Files.readString(fileName);
            System.out.println(file_content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) {
        //buffer();
        //file();
        //fileStream();
        //files();
    }
}

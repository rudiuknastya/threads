package task1;

public class Main {
    public static void main(String[] args) {
        WordPrinter wordPrinter = new WordPrinter();
        ThreadA threadA = new ThreadA(wordPrinter);
        ThreadB threadB = new ThreadB(wordPrinter);
        ThreadC threadC = new ThreadC(wordPrinter);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

package task1;

public class ThreadA extends Thread {
    private WordPrinter wordPrinter;

    ThreadA(WordPrinter wordPrinter) {
        this.wordPrinter = wordPrinter;
    }

    @Override
    public void run() {
        wordPrinter.printWord('A', 0);
    }
}

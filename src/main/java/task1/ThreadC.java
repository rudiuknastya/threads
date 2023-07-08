package task1;

public class ThreadC extends Thread{
    private WordPrinter wordPrinter;
    ThreadC(WordPrinter wordPrinter) {
        this.wordPrinter = wordPrinter;
    }
    @Override
    public void run() {
        wordPrinter.printWord('C', 2);
    }
}

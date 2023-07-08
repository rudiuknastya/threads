package task1;

public class ThreadB extends Thread{
    private WordPrinter wordPrinter;
    ThreadB(WordPrinter wordPrinter) {
        this.wordPrinter = wordPrinter;
    }
    @Override
    public void run() {
        wordPrinter.printWord('B',1);
    }
}

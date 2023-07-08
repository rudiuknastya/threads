package task1;

public class WordPrinter {
    int i = 0;
    //AtomicBoolean
    public synchronized void printWord(Character word, int index){
        while(i < 13){
            while(i%3 != index){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            i++;
            System.out.print(word);
            notifyAll();
        }
    }
}

package threadCreation;

public class ThreadToStop extends Thread{
    private boolean stop = false;
    @Override
    public void run() {
        int i = 0;
        while(!stop) {
            System.out.println(i);
            i++;
        }
    }
    public void stopTread(){
        stop = true;
    }
}

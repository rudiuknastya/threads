package threadCreation;

public class RunnableCalculationThread implements Runnable{
    int a;
    int b;
    public RunnableCalculationThread(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        System.out.println(a+ " - "+ b + " = "+ (a-b));
    }
}

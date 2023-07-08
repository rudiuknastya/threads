package threadCreation;

public class CalculationThread extends Thread{
    int a;
    int b;
    public CalculationThread(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        System.out.println(a+ " + "+ b + " = "+ (a+b));
    }
}

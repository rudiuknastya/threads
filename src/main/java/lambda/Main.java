package lambda;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> cr = x -> System.out.println(x+2);
        cr.accept(3);
        Supplier<Integer> s = () -> 2+3;
        System.out.println(s.get());
        Function<Integer,Integer> f = (x) -> x+2;
        System.out.println(f.apply(3));
        BinaryOperator<Integer> bn = (x, y) -> x+y;
        System.out.println(bn.apply(2,3));

        Printer printer = (a,b,c) -> System.out.print(a+" "+b+" "+c);
        printer.print("How","are","you");
        System.out.println();
        add((a,b,c) -> System.out.print(a+" "+b+" "+c));
    }

    public static void add (Printer printer){
        printer.print("How","are","you");
        System.out.print("?");
    }
}

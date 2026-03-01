package generics;

import generics.handler.GenericsHandler;

import java.math.BigDecimal;
import java.util.List;

public class Class6BoundedType extends GenericsHandler {

    @Override
    public void execute() {

        Template t1 = new Template();
        Template t2 = new Template();
        Template t3 = new Template();

        t1.value = 1;
        t2.value = 1.23;
        t3.value = new BigDecimal(23);
    //  t3.value = "Hi"; Uncommenting this will throw Compile time Error

        System.out.println("T1 : " + t1.value);
        System.out.println("T2 : " + t2.value);
        System.out.println("T3 : " + t3.value);

    }

    class Template<T extends Number> {
        T value;
    }
}

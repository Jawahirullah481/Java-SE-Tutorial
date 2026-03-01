package generics;

import generics.handler.GenericsHandler;

public class Class1GenericClass extends GenericsHandler {

    @Override
    public void execute() {

        Printer<String> stringPrinter = new Printer<>();
        Printer<Integer> integerPrinter = new Printer<>();

        stringPrinter.setData("String Value");
        integerPrinter.setData(123);

        System.out.println(stringPrinter.getData());
        System.out.println(integerPrinter.getData());

    }

    class Printer<T> {
        T data;

        void setData(T data) {
            this.data = data;
        }

        T getData() {
            return this.data;
        }
    }
}

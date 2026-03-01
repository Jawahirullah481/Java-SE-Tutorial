package generics;

import generics.handler.GenericsHandler;

public class Class4GenericConstructor extends GenericsHandler {

    @Override
    public void execute() {

        new GenericConstructorClass("String");
        new GenericConstructorClass(123);

    }

    class GenericConstructorClass {

        <T> GenericConstructorClass(T value) {
            System.out.println("Value is : " + value);
        }

    }
}

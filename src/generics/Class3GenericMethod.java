package generics;

import generics.handler.GenericsHandler;

public class Class3GenericMethod extends GenericsHandler {

    @Override
    public void execute() {
        this.printValue("Hi");
        this.printValue(1);
    }

    private <T> void printValue(T value) {
        System.out.println(value);
    }

}

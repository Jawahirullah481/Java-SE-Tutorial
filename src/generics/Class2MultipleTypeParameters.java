package generics;

import generics.handler.GenericsHandler;

public class Class2MultipleTypeParameters extends GenericsHandler {

    @Override
    public void execute() {

        Pair<Integer, String> pair = new Pair(1, "One");
        Pair<String, Integer> pair2 = new Pair("Two", 2);

        String value1 = pair.value;
        Integer value2 = pair2.value;

        System.out.println("Value 1 : " + value1);
        System.out.println("Value 2 : " + value2);

    }

    class Pair<X, Y> {

        X key;
        Y value;

        Pair(X key, Y value) {
            this.key = key;
            this.value = value;
        }
    }
}

package generics;

import generics.handler.GenericsHandler;

public class Class5CompleteGenericExample extends GenericsHandler {
    @Override
    public void execute() {
        Template<String> template = new Template("string", 123);
        template.getValue(23.4);
    }

    // 1. Generic Class
    class Template<A> {

        // 2. Variable in Generic Type
        A instanceVar;

        // 3. Generic Constructor
        <B> Template(A param1, B param2) {
            instanceVar = param1;

            System.out.println("Value 1 : " + param1);
            System.out.println("Value 2 : " + param2);
        }

        // 4. Generic Method
        <C> A getValue(C param) {
            System.out.println("Method Argument : " + param);
            return instanceVar;
        }
    }
}

package generics.factory;

import generics.*;
import generics.handler.GenericsHandler;

public class GenericsFactory {

    public static void execute() {

        String concept = "BoundedType";

        GenericsHandler obj;

        switch (concept) {
            case "CustomGenericClass" : obj = new Class1GenericClass(); break;
            case "MultipleTypeParameters" : obj = new Class2MultipleTypeParameters(); break;
            case "GenericMethod" : obj = new Class3GenericMethod(); break;
            case "GenericConstructor" : obj = new Class4GenericConstructor(); break;
            case "CompleteGenericExample" : obj = new Class5CompleteGenericExample(); break;
            case "BoundedType" : obj = new Class6BoundedType(); break;
            default: obj = new Class1GenericClass(); break;
        }

        obj.execute();

    }

}

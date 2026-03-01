package lambda.factory;

import lambda.Class1SimpleLambda;
import lambda.Class2PredefinedFunctionalInterfaces;
import lambda.Class3MethodReference;
import lambda.Class4ConstructorReference;
import lambda.handler.LambdaHandler;

public class LambdaFactory {

    public static void execute() {

        String concept = "ConstructorReference";

        LambdaHandler obj;

        switch (concept) {
            case "SimpleLambda" : obj = new Class1SimpleLambda(); break;
            case "PredefinedFunctionalInterfaces" : obj = new Class2PredefinedFunctionalInterfaces(); break;
            case "MethodReference" : obj = new Class3MethodReference(); break;
            case "ConstructorReference" : obj = new Class4ConstructorReference(); break;
            default: obj = new Class1SimpleLambda(); break;
        }

        obj.execute();

    }

}

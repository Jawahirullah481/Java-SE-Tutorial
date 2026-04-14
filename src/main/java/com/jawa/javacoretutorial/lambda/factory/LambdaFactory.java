package com.jawa.javacoretutorial.lambda.factory;

import com.jawa.javacoretutorial.lambda.Class1SimpleLambda;
import com.jawa.javacoretutorial.lambda.Class2PredefinedFunctionalInterfaces;
import com.jawa.javacoretutorial.lambda.Class3MethodReference;
import com.jawa.javacoretutorial.lambda.Class4ConstructorReference;
import com.jawa.javacoretutorial.lambda.handler.LambdaHandler;

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

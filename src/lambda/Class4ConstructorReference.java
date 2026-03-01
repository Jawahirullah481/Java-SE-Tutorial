package lambda;

import lambda.handler.LambdaHandler;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Class4ConstructorReference extends LambdaHandler {

    @Override
    public void execute() {

        Supplier<User> supplier = User::new; // Constructor 1

        Function<String, User> function = User::new; // Constructor 2

        BiFunction<String, Integer, User> biFunction = User::new; // Constructor 3


        User user1 = supplier.get();
        User user2 = function.apply("Jawahir");
        User user3 = biFunction.apply("Kamal", 23);

        System.out.printf("%s%n %s%n %s%n", user1, user2, user3);

    }

    class User {

        String username;
        int age;

        User() {}

        User(String username) {
            this.username = username;
        }

        User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Username : " + this.username + " - " + "Age : " + this.age;
        }

    }

}

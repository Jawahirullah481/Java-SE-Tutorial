package stream;

import stream.handler.StreamHandler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Class4PracticePrograms extends StreamHandler {
    @Override
    public void execute() {

        List<Integer> list = List.of(1,2,3,4,5,3,2,1);

        // 1. Count Even Numbers
        long count = list.stream().filter(num -> num % 2 == 0).count();
        System.out.println("Number of Even Numbers : " + count);


        // 2. Find max
        int maxValue = list.stream().max(Integer::compare).orElse(0);
        System.out.println("Maximum Value : " + maxValue);


        // 3. Sum of Numbers
        int sum = list.stream().reduce(Integer::sum).orElse(0);
        System.out.println("Sum of Numbers : " + sum);


        // 4. Print First Matching element
        list.stream().filter(num -> num % 2 == 0).findFirst().ifPresent(num -> System.out.println("First Event Element : " + num));


        // 5. Find Duplicate Numbers
        Set<Integer> added = new HashSet<>();
        List<Integer> duplicates = list.stream().filter(num -> !added.add(num)).collect(Collectors.toList());
        System.out.println("Duplicate Numbers : " + duplicates);


        // 6. Frequency of Each Element
        Map<Integer, Long> itemsCount = list.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println("Frequency : " + itemsCount);


        // 7. Flatten Nested List
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> twoMultiples = nestedList.stream().flatMap(childList -> childList.stream()).map(num -> num * 2).collect(Collectors.toList());
        System.out.println("Tow Multiples : " + twoMultiples);

        // 8. Highest Salary (NOTE : for primitive streams(IntStream, DoubleStream, LongStream), then already know how to compare. So, no need to use comparator for min() or max())
        double highestSalary = Employee.getEmployees().stream().mapToDouble(emp -> emp.salary).max().orElse(0);
        System.out.println("Highest Salary : " + highestSalary);

        // 9. Average Salary
        double averageSalary = Employee.getEmployees().stream().mapToDouble(emp -> emp.salary).average().orElse(0);
        System.out.println("Average Salary : " + averageSalary);
    }

    static class Employee {

        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        static List<Employee> getEmployees() {
            List<Employee> employeeList = List.of(
                    new Employee("Emp 1", 100),
                    new Employee("Emp 2", 200),
                    new Employee("Emp 3", 300),
                    new Employee("Emp 4", 400)
            );

            return employeeList;
        }

        @Override
        public String toString() {
            return this.name + " : " + this.salary;
        }

    }

}

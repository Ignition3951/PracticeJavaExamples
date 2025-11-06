package com.utk.interview;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.*;

public class InterviewUtil {

    public static void main(String[] args) {
        MathOperation add = (a, b) -> System.out.println(a + b);
        add.operate(5, 3);

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "task completed";
        };
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {

            Future<String> future = executor.submit(task);

            String result = future.get();
            System.out.println("The result from the future is:" + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        Predicate<String> isNotEmpty = s -> s != null && !s.isEmpty();

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test(null));

        //isPositive
        IntPredicate isPositive = n -> n > 0;
        System.out.println(isPositive.test(-5));
        System.out.println(isPositive.test(5));
        //isNotEmptyAndStartsWithA
        Predicate<String> isNotEmptyAndStartsWithA = isNotEmpty.and(s -> s.startsWith("A"));
        System.out.println(isNotEmptyAndStartsWithA.test("asdadasd"));
        System.out.println(isNotEmptyAndStartsWithA.test("Asdadasd"));

        //length
        ToIntFunction<String> stringLength = String::length;
        System.out.println(stringLength.applyAsInt("Hello"));
        //toUpperCase
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("Hello"));
        //upperCaseLength
        Function<String, Integer> toUpperCaseAndThenLength = toUpperCase.andThen(String::length);
        System.out.println(toUpperCaseAndThenLength.apply("hello first"));

        Consumer<String> printConsumer = s -> System.out.println("Consumed value is : " + s);
        printConsumer.accept("Hello");

        Consumer<String> convertToUppercase = s -> System.out.println("The converted value is : " + s.toUpperCase());
        convertToUppercase.accept("dummy value");

        Consumer<String> convertAndPrint = printConsumer.andThen(convertToUppercase);
        convertAndPrint.accept("print and convert");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseNames);

        List<Employee> employees = Arrays.asList(
                new Employee("John",20000l),
                new Employee("Doe",60000l),
                new Employee("Alice",50000l),
                new Employee("Perry",70000l));

        List<Employee> employeesSortedBySalary = employees.stream()
                .sorted(new EmployeeComparator())
                .toList();
        System.out.println("The sorted employees with salary is :"+employeesSortedBySalary);

    }
}

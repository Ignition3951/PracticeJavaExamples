package com.utk.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.*;

public class InterviewUtil {

    private static final String HELLO = "Hello";

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

        System.out.println(isNotEmpty.test(HELLO));
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test(null));

        //isPositive
        IntPredicate isPositive = n -> n > 0;
        System.out.println(isPositive.test(-5));
        System.out.println(isPositive.test(5));
        //isNotEmptyAndStartsWithA
        Predicate<String> isNotEmptyAndStartsWithA = isNotEmpty.and(s -> s.startsWith("A"));
        System.out.println(isNotEmptyAndStartsWithA.test("after"));
        System.out.println(isNotEmptyAndStartsWithA.test("After"));

        //length
        ToIntFunction<String> stringLength = String::length;
        System.out.println(stringLength.applyAsInt(HELLO));
        //toUpperCase
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply(HELLO));
        //upperCaseLength
        Function<String, Integer> toUpperCaseAndThenLength = toUpperCase.andThen(String::length);
        System.out.println(toUpperCaseAndThenLength.apply("hello first"));

        Consumer<String> printConsumer = s -> System.out.println("Consumed value is : " + s);
        printConsumer.accept(HELLO);

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
                new Employee("John", 20000L),
                new Employee("Doe", 60000L),
                new Employee("Alice", 50000L),
                new Employee("Perry", 70000L));

        List<Employee> employeesSortedBySalary = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .toList();
        System.out.println("The sorted employees with salary is :" + employeesSortedBySalary);

        int nthValue = 2;
        Optional<Employee> nthhighestSalary = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .skip(nthValue-1)
                .findFirst();
        Long salary=0L;
        if (nthhighestSalary.isPresent()) {
                salary = nthhighestSalary.get().getSalary();
        }
        System.out.println("The nth highest salary of employee is :" + salary);

    }
}

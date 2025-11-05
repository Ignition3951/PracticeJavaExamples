package com.utk.interview;

import java.util.concurrent.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class InterviewUtil {

    public static void main(String[] args) {
        MathOperation add = (a, b) -> System.out.println(a + b);
        add.operate(5, 3);

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "task completed";
        };
        try(ExecutorService executor = Executors.newSingleThreadExecutor()) {

        Future<String> future = executor.submit(task);

            String result = future.get();
            System.out.println("The result from the future is:" + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        Predicate<String> isNotEmpty = s -> s!=null && !s.isEmpty();

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test(null));

        //isPositive
        IntPredicate isPositive = n -> n>0;
        System.out.println(isPositive.test(-5));
        System.out.println(isPositive.test(5));
        //isNotEmptyAndStartsWithA
        Predicate<String> isNotEmptyAndStartsWithA = isNotEmpty.and(s-> s.startsWith("A"));
        System.out.println(isNotEmptyAndStartsWithA.test("asdadasd"));
        System.out.println(isNotEmptyAndStartsWithA.test("Asdadasd"));
    }
}

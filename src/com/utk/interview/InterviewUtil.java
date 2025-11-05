package com.utk.interview;

import java.util.concurrent.*;

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
    }
}

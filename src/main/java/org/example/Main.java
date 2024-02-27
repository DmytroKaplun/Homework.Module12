package org.example;

import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //1 task
        TimeMachine.startThreads();

        //2 task
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        StringBuffer builder = new StringBuffer();
        List<Thread> threads = new ArrayList<>();

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(number -> builder.append(", ").append("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(threadA);

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(number -> builder.append(", ").append("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threads.add(threadB);

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(number -> builder.append(", ").append("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threads.add(threadC);

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(number -> builder.append(", ").append(number));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threads.add(threadD);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(builder.toString().replaceFirst(", ", ""));
    }
}
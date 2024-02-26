package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //1 task
//       Thread thread1 = new Thread(() -> {
//            int counter = 0;
//            while (true) {
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(counter + " sec");
//                counter++;
//            }
//        });
//       thread1.start();
//
//        Thread thread2 = new Thread(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(5000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("Минуло 5 секунд");
//            }
//        });
//        thread2.start();

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
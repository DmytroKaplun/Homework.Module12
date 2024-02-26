package org.example;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


public class FizzBuzz {
    private int n;
    private int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizzbuzz(Consumer<Integer> consumer) throws InterruptedException {
        while (num <= n) {
            if (num % 15 == 0) {
                consumer.accept(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizz(Consumer<Integer> consumer) throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                consumer.accept(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Consumer<Integer> consumer) throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                consumer.accept(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(Consumer<Integer> consumer) throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                consumer.accept(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

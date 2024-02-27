package org.example;

public class TimeMachine {
    public static void startThreads() {
        Thread thread1 = new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(counter + " sec");
                counter++;
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Минуло 5 секунд");
            }
        });
        thread2.start();
    }
}

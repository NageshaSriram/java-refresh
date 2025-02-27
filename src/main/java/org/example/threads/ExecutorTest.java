package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task());
        executorService.execute(new TaskTwo());
        executorService.execute(new Task());
        executorService.execute(new TaskTwo());
        executorService.close();
    }
}


class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Task One: " + Thread.currentThread().getName());
    }
}
class TaskTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("Task Two: " + Thread.currentThread().getName());
    }
}
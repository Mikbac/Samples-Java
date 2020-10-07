package pl.samples.ExecutorService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
         * Executor service
         *
         * @param - minimum thread - 10
         * @param - maximum thread - 100
         * @param - keep alive time - 5 milliseconds
         * @param - TimeUnit - TimeUnit.MILLISECONDS
         * @param - Strategy - blocking queue to watch for tasks in future
         */
        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 5L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        /*
         * Demo task - lambda
         */
        Runnable task = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Task type lambda -> " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /*
         * Demo task - class
         */
        Runnable[] tasks = new Runnable[200];
        for (int i = 0; i < 200; i++)
            tasks[i] = new Task(i);

        /*
         * Execute tasks - with execute
         */
        executorService.execute(task);

        /*
         * Execute tasks - with execute
         */
        Arrays.stream(tasks)
                .forEach(executorService::execute);

        /*
         * Execute tasks - with submit
         */
        Future<String> result = executorService.submit(task, "Message then done");
        System.out.println(result.get());

        /*
         * Shut down the executor service
         *
         * Stop all actively executing tasks.
         * executorService.shutdownNow()
         *
         * Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
         * executorService.shutdown()
         *
         * It blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
         * executorService.awaitTermination(10, TimeUnit.MILLISECONDS)
         */

        executorService.shutdown();

    }
}

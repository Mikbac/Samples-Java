package pl.samples.ExecutorService;

/**
 * Created by MikBac on 08.10.2020
 */
public class Task implements Runnable {

    private final int id;

    public Task(final int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task type class -> " + id);
    }
}

package pl.samples.ExecutorService;

import lombok.extern.log4j.Log4j2;

/**
 * Created by MikBac on 08.10.2020
 */

@Log4j2
public class Task implements Runnable {

    private final int id;

    public Task(final int id) {
        this.id = id;
    }

    @Override
    public void run() {
        log.info("Task type class -> {}", id);
    }
}

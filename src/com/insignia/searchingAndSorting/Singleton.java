package com.insignia.searchingAndSorting;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

class LogMe {

    static LogMe logger;
    static int counter = 0;

    static ReentrantLock lock = new ReentrantLock(true);

    private LogMe() {

    }

    public static LogMe getLogger() {
        if (logger == null) {
            lock.lock();

            if (logger == null) {
                counter++;
                logger = new LogMe();
            }

            lock.unlock();
        }
        return logger;

    }

    public void log(String content) {
        System.out.println(content + "instance number " + counter);
    }
}

class Task implements Callable<LogMe> {

    @Override
    public LogMe call() {
        return LogMe.getLogger();
    }

}

public class Singleton {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<LogMe> user1Future = service.submit(new Task());
        Future<LogMe> user2Future = service.submit(new Task());

        LogMe user1 = user1Future.get();
        LogMe user2 = user2Future.get();

        user1.log("log ");
        user2.log("log ");
    }
}
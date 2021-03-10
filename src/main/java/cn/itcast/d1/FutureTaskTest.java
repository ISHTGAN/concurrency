package cn.itcast.d1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.debug("running");
            Thread.sleep(2000);
            return 100;
        });
        Thread thread = new Thread(futureTask);
        thread.start();

        log.debug("{}", futureTask.get());
    }
}

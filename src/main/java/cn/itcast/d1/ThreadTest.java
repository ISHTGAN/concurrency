package cn.itcast.d1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        thread.start();
        log.debug("running");
    }

    public static void runnableExample() {
        Runnable running = () -> {
            log.debug("running");
        };
        Thread thread = new Thread(running);
        thread.start();
    }
}

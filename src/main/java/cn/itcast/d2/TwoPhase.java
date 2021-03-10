package cn.itcast.d2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoPhase {
    static class TwoPhaseTermination {
        private Thread monitor;
        void start() {
            monitor = new Thread(() -> {
                while (true) {
                    Thread thread = Thread.currentThread();
                    if (thread.isInterrupted()) {
                        log.debug("被打断");
                        break;
                    } else {
                        try {
                            Thread.sleep(1000);
                            log.debug("监控中");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            thread.interrupt();
                        }
                    }
                }
            });
            monitor.start();
        }
        void stop() {
            monitor.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(3500);
        twoPhaseTermination.stop();
    }
}

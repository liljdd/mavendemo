package concurrencyTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lilj
 * @date 18/12/07
 */
public class LiftOffThread {

    @Test
    public void mainThread() {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("==========");
    }

    @Test
    public void basicThreads() {
        Thread t = new Thread(new LiftOff());
        t.start();
        //t.run();
        System.out.println("Waiting for LiftOff");
    }

    @Test
    public void moreBasicThreads() {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }

    @Test
    public void cachedThreadPool() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
            System.out.println("Waiting for LiftOff");
        }
        exec.shutdown();
    }

    @Test
    public void fixedThreadPool() {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
            System.out.println("Waiting for LiftOff");
        }
        System.out.println("yyyyyyyyyy");
        exec.shutdown();
        System.out.println("xxxxxxxxx");
    }


}

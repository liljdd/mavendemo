package concurrencyTest.deadLock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lilj
 * @date 18/12/12
 */
public class DiningPhilosophers {
    @Test
    public void deadLockTest() throws Exception {
        int ponder = 1;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
        }
        //阻塞主进程
        System.in.read();
        exec.shutdownNow();
    }

    @Test
    public void fixedDeadLockTest() throws Exception {
        int ponder = 5;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            if (i < (size - 1))
                exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
            else
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
        //阻塞主进程
        System.in.read();
        exec.shutdownNow();
    }

}


package concurrencyTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lilj
 * @date 18/12/07
 */
public class DaemonThreadTest {
    @Test
    public void mainThread() {
        DaemonThread launch = new DaemonThread();
        //死循环
        launch.run();
        System.out.println("==========");
    }

    @Test
    public void test1() throws InterruptedException {
        Thread t = new Thread(new DaemonThread());
        //设置守护线程
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
        System.out.println("==========");
    }

    @Test
    public void test2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new DaemonThread());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("all daemons start");
        //Thread.sleep(1000);
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new DaemonThread());
        }
        exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("========");
    }

}

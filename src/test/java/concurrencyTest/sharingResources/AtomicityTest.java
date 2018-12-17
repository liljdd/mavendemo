package concurrencyTest.sharingResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lilj
 * @date 18/12/10
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    /* public synchronized int getValue() {
         return i;
     }*/

    /**
     * 尽管return i 是原子性的，但是缺少同步使其数值可以处于不稳定的中间态时被读取
     */
    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }


}

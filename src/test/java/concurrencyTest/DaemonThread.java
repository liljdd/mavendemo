package concurrencyTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author lilj
 * @date 18/12/07
 */
public class DaemonThread implements Runnable {
    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        while (true) {
            try {
                //Thread.sleep(100);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "---" + sdf.format(new Date()));
            } catch (InterruptedException e) {
                System.out.println("sleep interruption");
            }
        }
    }
}

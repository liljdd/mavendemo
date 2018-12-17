package concurrencyTest;

import java.util.concurrent.Callable;

/**
 * @author lilj
 * @date 18/12/07
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult() {
    }

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        try {
            Thread.sleep(id * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "taskWithResult: " + Thread.currentThread().getName() + "--" + id;
    }
}

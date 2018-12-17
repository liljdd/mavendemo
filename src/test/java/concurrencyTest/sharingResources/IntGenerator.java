package concurrencyTest.sharingResources;

/**
 * @author lilj
 * @date 18/12/10
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}

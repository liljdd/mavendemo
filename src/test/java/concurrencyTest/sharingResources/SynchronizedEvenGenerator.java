package concurrencyTest.sharingResources;

/**
 * @author lilj
 * @date 18/12/10
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next() {
        ++currentEvenValue; // Danger point here!
        Thread.yield();// Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        SynchronizedEvenGenerator bean = new SynchronizedEvenGenerator();
        EvenChecker.test(bean);
    }
}

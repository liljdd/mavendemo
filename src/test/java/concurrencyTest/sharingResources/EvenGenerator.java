package concurrencyTest.sharingResources;

/**
 * @author lilj
 * @date 18/12/10
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue; // Danger point here!
        Thread.yield();// Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenGenerator bean = new EvenGenerator();
        EvenChecker.test(bean);
    }
}

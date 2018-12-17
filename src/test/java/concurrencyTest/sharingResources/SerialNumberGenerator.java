package concurrencyTest.sharingResources;

/**
 * @author lilj
 * @date 18/12/10
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
//    private static int serialNumber = 0;

    /**
     * volatile不会对递增不是原子性操作产生影响，能使用synchronized不考虑volatile
     * <p>
     * 原子操作是不能被线程调度机制中断的操作，一旦操作开始，那么它一定可以在可能发生的“上下文切换”之前（切换到其他线程）执行完成。
     * Java内置的基本类型，除了64位的long和double，读取和写入操作都是原子性的。因为JVM会将64位的读取和写入操作分离为两个32位的操作，
     * 这个过程中间可能产生线程切换。要获取long或者double的原子性操作，要使用volatile关键字。
     * 原子操作由线程机制来确保其不可中断，可以利用这种特性编写无锁的代码（尽管如此，还是不建议使用原子性操作来替代同步）。
     * 注意在Java中，递增和递减操作（++/--）不是原子操作。
     */
    //public static synchronized int nextSerialNumber() {
    public static int nextSerialNumber() {
//        return serialNumber = serialNumber + 1; // Not thread-safe
        return serialNumber++; // Not thread-safe
    }
}

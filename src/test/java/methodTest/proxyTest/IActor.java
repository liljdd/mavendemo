package methodTest.proxyTest;

/**
 * @author lilj
 * @date 18/07/19
 */
public interface IActor {
    /**
     * 基本演出
     *
     * @param money
     */
    public void basicAct(float money);

    /**
     * 危险演出
     *
     * @param money
     */
    public void dangerAct(float money);

}

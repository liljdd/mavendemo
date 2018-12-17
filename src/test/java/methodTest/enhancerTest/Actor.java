package methodTest.enhancerTest;

/**
 * @author lilj
 * @date 18/07/19
 */

/**
 * 基于子类的动态代理
 * 提供者：第三方的CGLib，如果报asmxxxx异常，需要导入asm.jar。
 * 要求：被代理类不能用final修饰的类（最终类）。
 */
public class Actor {
    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本的表演：" + money);
    }

    public void dangerAct(float money) {
        System.out.println("拿到钱，开始危险的表演：" + money);
    }

}

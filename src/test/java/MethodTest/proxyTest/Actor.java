package MethodTest.proxyTest;

/**
 * @author lilj
 * @date 18/07/19
 */
public class Actor implements IActor {
    public void basicAct(float money){
        System.out.println("拿到钱，开始基本的表演："+money);
    }

    public void dangerAct(float money){
        System.out.println("拿到钱，开始危险的表演："+money);
    }

}

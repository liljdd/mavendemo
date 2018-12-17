package concurrencyTest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lilj
 * @date 18/12/07
 */
public class TaskWithResultThread {
    @Test
    public void callBackTest() throws ExecutionException, InterruptedException {
        //Future<String> f = new FutureTask<String>(new TaskWithResult(1));
        FutureTask<String> f = new FutureTask<String>(new TaskWithResult(2));
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(f);
        exec.shutdown();
        String s = f.get();
        System.out.println("===> " + s);
    }

    @Test
    public void callBackTest2() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        FutureTask<String> f1 = new FutureTask<String>(new TaskWithResult(8));
        FutureTask<String> f2 = new FutureTask<String>(new TaskWithResult(10));
        ExecutorService exec = Executors.newCachedThreadPool();
        System.out.println("1---" + sdf.format(new Date()));
        exec.execute(f1);
        System.out.println("2---" + sdf.format(new Date()));
        exec.execute(f2);
        System.out.println("3---" + sdf.format(new Date()));
        exec.shutdown();//不需执行结束即可关闭
        System.out.println("4---" + sdf.format(new Date()));
        String s1 = f1.get();//get()方法等待任务执行完成然后才输出内容
        System.out.println("5---" + sdf.format(new Date()));
        String s2 = f2.get();//get()方法等待任务执行完成然后才输出内容
        System.out.println("6---" + sdf.format(new Date()));
        System.out.println("s1===> " + s1);
        System.out.println("s2===> " + s2);
    }

    @Test
    public void callBackTest3() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> f1 = exec.submit(new TaskWithResult(1));
        Future<String> f2 = exec.submit(new TaskWithResult(2));
        exec.shutdown();
        System.out.println(f1.get());
        System.out.println(f2.get());

    }

    @Test
    public void callBackTest4() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get() + "--->" + sdf.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }


    }


}

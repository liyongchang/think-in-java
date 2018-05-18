package base;


import java.util.concurrent.*;

/**
 * Created by liyongchang on 2018/5/17.
 */
public class TastCallableAndFuture {
/*
　　Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。
    必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
 */

    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(1000);
            int sum = 0;
            for (int i = 0; i < 10001111; i++)
                sum += i;
            return sum;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");

        try {
            System.out.println(result.isDone());
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
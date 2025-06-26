package leetcode.Thread;
import java.util.concurrent.*;

public class future {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor1 = Executors.newFixedThreadPool(10);

        // 提交一个耗时任务
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // 模拟耗时
            return 42;
        });

        System.out.println("任务已提交，等待结果...");

        Integer result = future.get(); // 阻塞直到完成
        System.out.println("计算结果是: " + result);

        executor.shutdown();
    }
}

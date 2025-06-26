package leetcode.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RPC {
    // 定义个线程池
    static ExecutorService ThreadPool = Executors.newFixedThreadPool(20);

    // 模拟第三方的接口！
    public static String rpcGetDetailsById(int id) {
        // 模拟 rpc service 耗时
        try {
            Thread.sleep(20L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "details " + id;
    }

    // 模拟己方 批量调用第三方接口！
    public static void main(String[] args) {
        // rpc 请求参数
        List<Integer> requestIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {requestIds.add(i);}

        // rpc 调用
        List<String> results = batchGetDetails(requestIds);

        for (String result : results) {
            System.out.println(result);
        }

        // 关闭线程池
        ThreadPool.shutdown();
    }

    /**
     * 某个 rpc service 的接口只提供单个调用，此处需要做一个封装，多次请求后返回，要求按照顺序返回。
     */
    public static List<String> batchGetDetails(List<Integer> ids) {
        // 定义List的future对象来接收线程池返回的结果
        List<Future<String>> futures = new ArrayList<>();

        // TODO 在此处实现批量调用
        for (Integer id : ids) {
            Future<String> future = ThreadPool.submit(() -> rpcGetDetailsById(id) );
            futures.add(future);
        }

        List<String> results = new ArrayList<>();
        for (Future<String> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

}



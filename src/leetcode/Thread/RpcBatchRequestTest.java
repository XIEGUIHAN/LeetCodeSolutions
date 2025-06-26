import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RpcBatchRequestTest {

    static RpcService rpcService = new RpcService();
    // 使用 ThreadPoolExecutor 创建线程池
//    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

    static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // rpc 请求参数
        List<Integer> requestIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            requestIds.add(i);
        }

        // rpc 调用
        List<String> results = batchGetDetails(requestIds);

        // 输出
        for (String result : results) {
            System.out.println(result);
        }

        // 关闭线程池
        executor.shutdown();
    }

    public static List<String> batchGetDetails(List<Integer> ids) {
        // 提交所有任务到线程池
        List<Future<String>> futures = new ArrayList<>();
        for (Integer id : ids) {
            Future<String> future = executor.submit(() -> rpcService.rpcGetDetailsById(id));
            futures.add(future);
        }

        // 按顺序获取结果
        List<String> results = new ArrayList<>();
        for (Future<String> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("RPC调用失败", e);
            }
        }
        return results;
    }
}

class RpcService {
    public String rpcGetDetailsById(int id) {
        // 模拟 rpc service 耗时
        try {
            Thread.sleep(20L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "details " + id;
    }
}
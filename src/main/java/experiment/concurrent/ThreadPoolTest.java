package experiment.concurrent;

import experiment.exception.BusinessException;
import org.apache.lucene.util.NamedThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 各种类型的线程池
 *
 * @author haze
 * @date created at 2018/8/31 下午5:40
 */
public class ThreadPoolTest {
    /**
     * 1.corePool数值测试
     * 2.policy
     * <p>
     * corePoolSize：0
     * maxPoolSize：Integer.MAX_VALUE
     * keepAliveTime：60s
     * workQueue: SynchronousQueue
     */
    @Test
    public void doSth() {
//        Executors.newFixedThreadPool()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new NamedThreadFactory("cart-pool")
        );
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//
//            }
//        });

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("list");
                throw new BusinessException("runtime err");
            });
            System.out.println("poolSize:" + executor.getPoolSize());//+ "queue:" + executor.getQueue()
        }
        // 关闭线程池
//        executor.shutdown();
    }
}

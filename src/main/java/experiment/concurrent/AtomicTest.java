package experiment.concurrent;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author haxe
 * @date created at 2020/5/8 17:38
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicReference<String> reconsumeKeyRef = new AtomicReference<>();
        ThreadPoolExecutor   threadPoolExecutor = new ThreadPoolExecutor(13, 100,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory("更新回收面单线程池"),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            threadPoolExecutor.execute(
                    ()->{
//                        reconsumeKeyRef.set("i:"+ finalI);
                    }
            );
        }

        String s = reconsumeKeyRef.get();
        System.out.println(s);
        System.exit(1);
    }
}

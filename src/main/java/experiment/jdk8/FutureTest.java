package experiment.jdk8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haze
 * @date created at 2020/4/10 9:42 上午
 */
public class FutureTest {
    public static void main(String[] args) throws Exception {
        System.out.println("-----");
        Thread.sleep(25000);
        handle();
    }

    public static void handle() throws Exception {

        System.out.println("睡眠结束");
        AtomicInteger a = new AtomicInteger(0);


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("-->");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Random().nextInt(10);

        });


        future.handle((param, throwable) -> {
            a.set(1);

            System.out.println("-- 睡眠结束");
            return a;
        });
        System.out.println(a.get());
        Thread.sleep(3000);
        System.out.println(a.get());

    }
}

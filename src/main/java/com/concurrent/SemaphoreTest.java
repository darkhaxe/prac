package com.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author haze
 * @date created at 2018/8/31 下午5:28
 * @see
 */
@SuppressWarnings("ALL")
public class SemaphoreTest {
    //初始化10个信号量在信号包中，让ABCD4个线程分别去获取
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        doTest(semaphore);
    }

    /**
     * 获取信号量semaphore.acquire(n)必须一次性拿到N个,否则一直阻塞
     * 参见D获取10个要等ABC全部释放
     */
    private static void doTest(final Semaphore semaphore) throws InterruptedException {
        //线程A初始获取了4个信号量，然后分3次释放了这4个信号量
        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    semaphore.acquire(4);
                    System.out.println(Thread.currentThread().getName() + " get 4 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " release 1 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(1);
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " release 1 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(1);
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " release 2 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadA.setName("threadA");

        //线程B初始获取了5个信号量，然后分2次释放了这5个信号量
        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    semaphore.acquire(5);
                    System.out.println(Thread.currentThread().getName() + " get 5 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " release 2 semaphore"
                            + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(2);
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " release 3 semaphore"
                            + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadB.setName("threadB");

        //线程C初始获取了4个信号量，然后分1次释放了这4个信号量
        Thread threadC = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("[c]当前可用信号量" + semaphore.availablePermits() + " 尝试获取4个" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.acquire(4);
                    System.out.println("[c] " + Thread.currentThread().getName() + " get 4 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    Thread.sleep(1000);
                    System.out.println("[c] " + Thread.currentThread().getName() + " release 4 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadC.setName("threadC");

        //线程D初始获取了10个信号量，然后分1次释放了这10个信号量
        Thread threadD = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("[d]当前可用信号量" + semaphore.availablePermits() + " 尝试获取10个");
                    semaphore.acquire(10);
                    System.out.println("[d] " + Thread.currentThread().getName() + " get 10 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    Thread.sleep(1000);
                    System.out.println("[d] " + Thread.currentThread().getName() + " release 10 semaphore" + ",剩余" + semaphore.availablePermits() + "个");
                    semaphore.release(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadD.setName("threadD");

        //线程A和线程B首先分别获取了4个和5个信号量，总信号量变为了1个
        threadA.start();
        threadB.start();
        Thread.sleep(1);
        //线程C尝试获取4个发现不够则等待
        threadC.start();
        Thread.sleep(1);
        //线程D尝试获取10个发现不够则等待
        threadD.start();
    }


}

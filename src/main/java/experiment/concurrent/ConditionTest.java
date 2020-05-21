package experiment.concurrent;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对put操作加锁,使得同一个时间只有一个线程可以访问put方法
 * <p>
 * 对take方法加锁,是用一把锁,因此在线程1执行put时,线程2的take将阻塞
 * @author haxe
 * @date created at 2020/5/21 14:57
 */
public class ConditionTest {

    public static void main(String[] arg) {
        BlockList blockList = new BlockList(10);
        Producer producer = new Producer(blockList);
        Consumer consumer = new Consumer(blockList);
        new Thread(producer, "producer").start();
        new Thread(consumer, "consumer").start();
    }
}

class BlockList {
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int maxSize;
    private List<Date> storage;

    BlockList(int size) {
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        maxSize = size;
        storage = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            //如果队列满了,阻塞生产线程(本方法)
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + "写入队列满了,开始阻塞");
                //await的释放操作在take线程中触发
                notFull.await();
            }
            storage.add(new Date());
            System.out.println(Thread.currentThread().getName() + " 写入元素,blockList.size:" + storage.size());
            Thread.sleep(1000);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            //如果队列空了,阻塞消费线程(本方法)
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "取出队列空了,开始阻塞");
                notEmpty.await();
            }
            ((LinkedList<Date>) storage).poll();
            System.out.println(Thread.currentThread().getName() + " 取出元素,blockList.size:" + storage.size());
            Thread.sleep(1000);
            notFull.signalAll();//唤醒生产线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private BlockList blockList;

    Producer(BlockList b) {
        blockList = b;
    }

    @Override
    public void run() {
        while (true) {
            blockList.put();
        }
    }
}

class Consumer implements Runnable {
    private BlockList blockList;

    Consumer(BlockList b) {
        blockList = b;
    }

    @Override
    public void run() {
        while (true) {
            blockList.take();
        }
    }
}
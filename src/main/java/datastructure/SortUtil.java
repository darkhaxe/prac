package datastructure;

import java.util.Random;

/**
 * @author haze
 * @date created at 2019/1/8 9:46 PM
 */
public class SortUtil {


    public static void main(String[] args) {
        generateRandomArray(1000000);
    }

    /**
     * @param max 最大值
     * @return 生成一个[0, max]的元素个数max+1个的数组
     */
    public static Integer[] generateRandomArray(int max) {
        long start = System.currentTimeMillis();
        Integer[] arr = new Integer[max + 1];
        Random rand = new Random();
        for (int i = 0; i < max + 1; i++) {
            int num = rand.nextInt(max + 1);
//            System.out.println(num);
            arr[i] = num;
        }
        long end = System.currentTimeMillis();
        System.out.println("生成随机数组耗时:" + (end - start) + "ms");
        return arr;
    }

    /**
     * 产生一个有序数组
     */
    public static Integer[] generateOrderedArray(int max) {
        Integer[] arr = new Integer[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static <T> void swap(int firstIndex, int secondIndex, T[] arr) {
        T tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

}

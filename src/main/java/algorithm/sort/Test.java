package algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.TimeUnit;

import static algorithm.SortUtil.generateOrderedArray;
import static algorithm.SortUtil.generateRandomArray;

/**
 * @author haze
 * @date created at 2019/1/10 12:53 PM
 */
public class Test {
    public static void main(String[] args) {
//        testPrimitiveQuickSort();

        //近乎有序的数组,导致时间复杂度退化到O(n^2),超过12000导致stackoverflow
//        testOrderedArr(100000);

        test3Way();

    }

    private static void test3Way() {
//        Integer[] arr = {4, 6, 2, 3, 1, 5, 7, 8};
        int max = 1000000;
        Integer[] arr = generateRandomArray(max - 1);
        long start = System.currentTimeMillis();
        new QuickSort3Ways<Integer>().quickSort(arr, 0, max-1);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
//        System.out.println(JSON.toJSONString(arr));
    }

    private static void testPrimitiveQuickSort() {
        Integer[] arr = {4, 6, 2, 3, 1, 5, 7, 8};
        long start = System.currentTimeMillis();
        // 百万数据500ms排序完成
//        int max = 1000000;
//        Integer[] arr = generateRandomArray(max - 1);
//        new QuickSort<Integer>().quickSort(arr, 0, max - 1);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arr[i]);
//        }
//        new QuickSort<Integer>().quickSort(arr,0, 7);

        new QuickSort<Integer>().quickSort(arr, 0, 7);
        System.out.println(JSON.toJSONString(arr));

        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }

    private static void testOrderedArr(int max) {
        Integer[] orderedArray = generateOrderedArray(max);
        long start = System.nanoTime();
//        new QuickSort<Integer>().quickSort(orderedArray, 0, 12000 - 1);
        new QuickSort2Ways<Integer>().quickSort(orderedArray, 0, max - 1);
        long end = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println(orderedArray[i]);
        }
        long duration = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println("耗时:" + duration + "ms");
    }
}

package datastructure.sort;

import static datastructure.SortUtil.generateRandomArray;
import static datastructure.SortUtil.swap;

/**
 * 快排
 *
 * @author haze
 * @date created at 2019/1/8 9:10 PM
 */
public class QuickSort<T extends Comparable<T>> {
    public static void main(String[] args) {
//        Integer[] arr = {4, 6, 2, 3, 1, 5, 7, 8};
        long start = System.currentTimeMillis();
        // 百万数据500ms排序完成
        int max = 1000000;
//        int min = 1;
        Integer[] arr = generateRandomArray(max - 1);
        new QuickSort<Integer>().quickSort(arr, 0, max - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
//        quickSort(arr,0, 7);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }

    /**
     * 对arr[l..r]进行排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(T[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int dividingIndex = partition(arr, left, right);
        quickSort(arr, left, dividingIndex - 1);
        quickSort(arr, dividingIndex + 1, right);
    }

    /**
     * 分区整理
     * 对arr[l..r]进行分区
     *
     * @param arr
     * @param left
     * @param right
     * @return 返回分界点dividingIndex, 使得arr[l...dividingIndex-1] < arr[dividingIndex] < arr[dividingIndex+1..right]
     */
    private int partition(T[] arr, int left, int right) {
        T firstElement = arr[left];
        int dividingIndex = left;
        for (int currentIndex = left + 1; currentIndex <= right; currentIndex++) {
            /*
            在遍历数组的时候,将数组整理成三部分:<1st,1st,>1st;并记录1st的最后落在的索引.
            [first|small-then-1st...|dividingIndex|large-then-first...|currentIndex|....未整理部分]
            每部分不保证有序,递归到两个元素的排序,递归直到一个元素的时候有序
             */
            if (arr[currentIndex].compareTo(firstElement) < 0) {
                swap(dividingIndex + 1, currentIndex, arr);
                dividingIndex++;
            }
        }
        swap(left, dividingIndex, arr);
        return dividingIndex;
    }


}
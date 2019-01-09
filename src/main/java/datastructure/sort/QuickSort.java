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
        Integer[] arr = generateRandomArray(max - 1);
        new QuickSort<Integer>().quickSort(arr, 0, max - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
//        new QuickSort<Integer>().quickSort(arr,0, 7);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }

    /**
     * 对arr[l..r]进行排序
     */
    private void quickSort(T[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int dividingIndex = partition(array, leftBound, rightBound);
        quickSort(array, leftBound, dividingIndex - 1);
        quickSort(array, dividingIndex + 1, rightBound);
    }

    /**
     * 分区整理
     * 对arr[l..r]进行分区
     *
     * @return 返回分界点dividingIndex, 使得arr[leftBound...dividingIndex-1] < array[dividingIndex] < array[dividingIndex+1..rightBound]
     */
    private int partition(T[] array, int leftBound, int rightBound) {
        T firstElement = array[leftBound];
        int dividingIndex = leftBound;
        for (int currentIndex = leftBound + 1; currentIndex <= rightBound; currentIndex++) {
            /*
            在遍历数组的时候,将数组整理成三部分:<1st,1st,>1st;并记录1st的最后落在的索引.
            [first|small-then-1st...|dividingIndex|large-then-first...|currentIndex|....未整理部分]
            每部分不保证有序,递归到两个元素的排序,递归直到一个元素的时候有序
             */
            if (array[currentIndex].compareTo(firstElement) < 0) {
                swap(dividingIndex + 1, currentIndex, array);
                dividingIndex++;
            }
        }
        swap(leftBound, dividingIndex, array);
        return dividingIndex;
    }


}
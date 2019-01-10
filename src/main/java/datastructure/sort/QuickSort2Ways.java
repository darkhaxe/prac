package datastructure.sort;

import datastructure.SortUtil;

import java.util.Random;


/**
 * 改进快排,使用随机数选取起始元素
 *
 * @author haze
 * @date created at 2019/1/9 1:37 PM
 */
public class QuickSort2Ways<T extends Comparable<T>> {

    /**
     * 随机算法,仍然容易stackOverflow
     * @param arr
     * @param leftBound
     * @param rightBound
     */
    public void quickSort(T[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }

        int p = partition(arr, leftBound, rightBound);
        quickSort(arr, leftBound, p - 1);
        quickSort(arr, p + 1, rightBound);
    }

    private int partition(T[] arr, int leftBound, int rightBound) {
        Random rand = new Random();
        int random = rand.nextInt(rightBound - leftBound + 1);
        SortUtil.swap(leftBound, random, arr);

        T first = arr[leftBound];
        int dividingIndex = leftBound;
        for (int current = leftBound + 1; current < rightBound; current++) {

            if (arr[current].compareTo(first) < 0) {
                SortUtil.swap(current, dividingIndex + 1, arr);
                dividingIndex++;
            }
        }
        SortUtil.swap(leftBound, dividingIndex, arr);
        return dividingIndex;
    }
}

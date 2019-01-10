package datastructure.sort;

import static datastructure.SortUtil.swap;

/**
 * 快排
 *
 * @author haze
 * @date created at 2019/1/8 9:10 PM
 */
public class QuickSort<T extends Comparable<T>> {


    /**
     * 对arr[l..r]进行排序
     */
    public void quickSort(T[] array, int leftBound, int rightBound) {
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
            如何整理?
                当前遍历位置的元素array[currentIndex]<firstElement(作为分界点的元素),则将当前元素的位置交换到 <1区间的最后一位;并移动分界点元素的索引;
                当前遍历位置的元素array[currentIndex]>firstElement(作为分界点的元素),则将当前元素的位置不变,后续此部分坐落在>1区间;
               todo 当前遍历位置的元素array[currentIndex]=firstElement(作为分界点的元素)
            每部分不保证有序,递归到两个元素的排序,递归直到一个元素的时候有序
             */
            if (array[currentIndex].compareTo(firstElement) < 0) {
                swap(currentIndex, dividingIndex + 1, array);
                dividingIndex++;
            }
        }
        swap(leftBound, dividingIndex, array);
        return dividingIndex;
    }


}
package datastructure.sort;

import com.alibaba.fastjson.JSON;

import static datastructure.SortUtil.swap;

/**
 * @author haze
 * @date created at 2019/1/9 1:38 PM
 */
public class QuickSort3Ways<T extends Comparable<T>> {

    public void quickSort(T[] array, int leftBound, int rightBound) {
        //todo 元素个数小于15,插入排序
        if (rightBound - leftBound < 15) {

        }
        int p = partition(array, leftBound, rightBound);
        partition(array, leftBound, p - 1);
        partition(array, p + 1, rightBound);
    }

    private int partition(T[] array, int leftBound, int rightBound) {

        int leftCursor = leftBound + 1, rightCursor = rightBound;
        T firstElement = array[leftBound];
        while (true) {
            //左侧开始遍历,假如遍历的元素都小于firstElement,
            // 将游标不断自增直到右边界
            while (leftCursor <= rightBound &&
                    array[leftCursor].compareTo(firstElement) < 0) {
                //左侧遍历结束
                leftCursor++;
            }
            while (rightCursor >= leftBound + 1 &&
                    array[rightCursor].compareTo(firstElement) > 0) {
                //右侧遍历结束
                rightCursor--;
            }

            if (leftCursor > rightCursor) {
                break;
            }
            //运行至此,说明左右区间找到了需要交换的元素
            //先交换元素,再递增左右游标
            System.out.println("leftCursor=" + leftCursor + " rightCursor=" + rightCursor + " arr:" + JSON.toJSONString(array));

            swap(leftCursor, rightCursor, array);
            leftCursor++;
            rightCursor--;
            System.out.println("leftCursor=" + leftCursor + " rightCursor=" + rightCursor + " arr:" + JSON.toJSONString(array));

        }
        //遍历结束,需要交换firstElement的位置到右游标的位置
        swap(leftBound, rightCursor, array);
        return rightCursor;
    }
}

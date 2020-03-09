package algorithm.sort;

import com.alibaba.fastjson.JSON;

import static algorithm.SortUtil.swap;

/**
 * @author haze
 * @date created at 2019/1/9 1:38 PM
 */
public class QuickSort3Ways<T extends Comparable<T>> {

    public void quickSort(T[] array, int leftBound, int rightBound) {

        if (leftBound >= rightBound) {
            return;
        }
//        if (rightBound - leftBound < 15) {
        //todo 元素个数小于15,插入排序
//        }
        T firstElement = array[leftBound];

        int leftCursor = leftBound;
        int rightCursor = rightBound + 1;
        int currentIndex = leftBound + 1;
        /*
         * 遍历中存在4个区间[(<firstElement)...] [(=firstElement)...] [currentIndex...(未遍历结束的区间)][(>firstElement)...]
         */
        while (currentIndex < rightCursor) {
            //左侧开始遍历,假如遍历的元素(currentIndex)小于标定元素(firstElement),将当前元素移动到<firstElement的区间
            if (array[currentIndex].compareTo(firstElement) < 0) {
                swap(currentIndex, leftCursor + 1, array);
                leftCursor++;
                currentIndex++;
//                logChange(array, leftCursor, rightCursor);
            } else if (array[currentIndex].compareTo(firstElement) > 0) {
                swap(currentIndex, rightCursor - 1, array);
                rightCursor--;
//                logChange(array, leftCursor, rightCursor);
            } else {
                currentIndex++;
            }
            //运行至此,说明左右区间找到了需要交换的元素
            //先交换元素,再递增左右游标
//            logChange(array, leftCursor, rightCursor);
        }
        //遍历结束,需要交换firstElement的位置到右游标的位置
        swap(leftBound, leftCursor, array);
//        logChange(array, leftCursor, rightCursor);
        quickSort(array, leftBound, leftCursor - 1);
        quickSort(array, rightCursor, rightBound);
    }

    private void logChange(T[] array, int leftCursor, int rightCursor) {
        System.out.println("leftCursor=" + leftCursor + " rightCursor=" + rightCursor + " arr:" + JSON.toJSONString(array));
    }

}

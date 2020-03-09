package datastructure.tree;

import java.util.ArrayList;

/**
 * 最大堆/大顶堆
 *
 * @author haze
 * @date created at 2020/2/1 9:56 下午
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    /**
     * @return 父节点的index
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("parent node not found");
        }
        return (index - 1) / 2;
    }

    /**
     * 左子节点索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 右子节点索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     */
    private void add(E e) {
        data.add(e);
        //上浮:最后一个元素
        siftUp(data.size() - 1);
    }

    private void siftUp(int index) {
        int parentIndex = parent(index);
        E parentNode = data.get(parentIndex);

        E currentNode = data.get(index);
        if (index == 0) {
            return;
        }

        if (currentNode.compareTo(parentNode) > 0) {
            //与父节点交互位置
            swap(index, parentIndex, currentNode, parentNode);
            //递归调用,继续与父节点比较
            siftUp(parentIndex);
        }

    }

    private void swap(int currentIndex, int targetIndex,
                      E currentNode, E targetNode) {
        data.set(targetIndex, currentNode);
        data.set(currentIndex, targetNode);
    }

    /**
     * 下沉
     */
    private void siftDown(int index) {
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        E leftChild = data.get(leftChildIndex);
        E rightChild = data.get(rightChildIndex);
        if (leftChild == null && rightChild == null) {
            return;
        }

        E currentNode = data.get(index);
        if (leftChild == null) {
            //交换父节点与右节点
            swap(index, rightChildIndex, currentNode, rightChild);
            siftDown(rightChildIndex);
        } else if (rightChild == null) {
            //交换父节点与左节点
            swap(index, leftChildIndex, currentNode, leftChild);
            siftDown(leftChildIndex);
        } else {
            //左右节点都非空
            if (leftChild.compareTo(rightChild) > 0) {
                //交换父节点与左节点
                swap(index, leftChildIndex, currentNode, leftChild);
                siftDown(leftChildIndex);
            } else {
                //交换父节点与右节点
                swap(index, rightChildIndex, currentNode, rightChild);
                siftDown(rightChildIndex);
            }
        }

    }

    /**
     * 取出堆顶元素
     * 取出堆顶元素(最大值),将数组最末元素放到堆顶,执行siftDown下沉
     */
    public E extractMax(){
        if(data.isEmpty()){
            throw new UnsupportedOperationException("heap is empty");
        }
        E max = data.get(0);
        int lastIndex = data.size() - 1;
        E last = data.get(lastIndex);
        data.set(0,last);
        data.remove(lastIndex);
        siftDown(0);
        return max;
    }
    //
    //              10
    //             /   \
    //            11   12
    //           / \   / \
    //          7   6 9
    //关注父节点,子节点索引计算方法
    //2.使用数组根据角标取值
    //3.理解siftUp,siftDown的原理
    //  siftUp:只需与父节点一路比较直到根节点
    //  siftDown:与左右子节点较大的比较交换
    //取出堆顶元素(最大值),将数组最末元素放到堆顶,执行siftDown下沉

}

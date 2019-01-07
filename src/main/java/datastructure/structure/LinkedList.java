package datastructure.structure;

/**
 * 链表
 *
 * @author haze
 * @date created at 2018/9/4 下午3:11
 */
public class LinkedList<E> {


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node n) {
            this.e = e;
            this.next = n;
        }

        public Node() {
            this(null, null);
        }

        /**
         * 创建头结点
         *
         * @param e
         */
        public Node(E e) {
            this(e, null);
        }
    }


    //头结点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }


    /**
     * 实际上按index查找链表在现实中少见
     */
    int add(int index, E e) {
        Node prev = dummyHead;
        //从dummyHead开始查找下一个节点 获取index的节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        new Node(e,prev.next);
        return -1;
    }
    //2.addFirst

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}

package datastructure.linkedlist;

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

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
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


    /**
     * 虚拟头结点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }


    /**
     * 实际上按index查找链表在现实中少见
     *
     * @param index 0-based 从0开始
     */
    void add(int index, E e) {
        Node prev = dummyHead;
        //从dummyHead开始查找下一个节点 获取index的节点
        //获取第index个链表的元素,只能从链表头.next不断查找,复杂度是O(N)
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //创建一个新节点
        //将第index个元素的next指向新创建的节点
//简化写法:        prev.next = new Node(e, prev.next);
        //详细写法
        //1.创建新的Node
        Node node = new Node(e);
        //2.给node的next赋值,将现在的元素prev的next的元素(可以为null)挂到新建node.next[注意不是挂到node]
        node.next = prev.next;
        //3.将新建节点挂到现在的元素prev的next指针
        prev.next = node;
        //
        size++;
    }

    //todo old version[4-2] 添加dummyHead之前的结构
    void addFirst(E e) {
        //1.创建新的Node
        Node node = new Node(e);
        //2.给node的next赋值,指向现在的head
        node.next = dummyHead;
        //3.给成员变量 dummyHead赋值,指向当前方法内的私有变量 node;
        dummyHead = node;
        //todo 在方法结束后,node被回收;
        // Q:为何这个操作不会造成dummyHead死循环,指向自己? 疑问主要是因为 对 = 操作符的理解不彻底
        // 成员变量 dummyHead原本指向一个地址A;在操作2,node.next指向了地址A;
        // 操作3,把 '操作符 = ' 右边的node的地址B(引用)赋值给dummyHead;

        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}

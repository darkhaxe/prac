package leetcode.linkedlist;

/**
 * 反转单链表
 *
 * @author haze
 * @date created at 2020/4/12 5:30 下午
 */
public class ReverseList {

    //         旧链表              新链表
    // 1 -> 2 -> 3 -> 4
    // 2 -> 3 -> 4           1
    // 3 -> 4                2 -> 1
    // 4                     3 -> 2 -> 1
    public ListNode reverseList(ListNode head) {
        ListNode newDummyHead = new ListNode(-1);
        while (head != null) {
            //暂存原链表的next元素
            ListNode oldLinkedListNextNode = head.next;
            //头插法
            //旧链表头元素 + 新链表(上一次循环为止)  得到一个新链表,其头元素是head
            //newDummyHead.next代表的是新链表
            addHeadToNewList(head, newDummyHead);
            //将新链表的头元素设置成刚拼接好的head元素
            newDummyHead.next = head;
            //调整旧链表,去掉头元素
            head = oldLinkedListNextNode;
        }
        return newDummyHead.next;
    }

    //递归函数返回之后,代表什么?
    //当入参是最后一个node节点,会递归返回 单节点 1->null,也可看作是递归反转 此结果是递归完成了,实现了函数的含义
    //函数的含义是:
    // 入参         返回
    // 3->2->1    1->2->3
    // 2->1       1->2
    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //4->3->2->1->null
        //当head=2,reversedList开始返回,返回值为 1->null
        ListNode reversedList = reverseRecursive(head.next);
        /*
        开始处理head节点与后继节点
        转换前: 2->1->null
        转换后: 1->2->null (此时reversedList发生了变化,刚好可以带上当前head节点)
        实际上调整之后的存在两条链表:
            1->2->null
            4->3->2->null
        再返回上层,节点3关系调整:
        3->2->null => 2->3->null( 1是2的前驱  1->2->3->null)
         */
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return reversedList;

    }

    private void addHeadToNewList(ListNode head, ListNode newDummyHead) {
        ListNode newLinkedList = newDummyHead.next;
        head.next = newLinkedList;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode list = new ReverseList().reverseList(n1);
        list.print();
        new ReverseList().reverseRecursive(list).print();
    }
}

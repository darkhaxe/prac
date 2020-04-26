package leetcode.linkedlist;

/**
 * 从有序链表删除重复节点
 *
 * @author haze
 * @date created at 2020/4/26 1:22 下午
 */
public class RemoveDuplicatesInSortedList {
    /**
     * 1->2->2->3->3->3
     * => 1->2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //1.定义函数功能:给定一个头结点,返回删除了重复元素的链表

        //2.定义递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        //3.等价关系式
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);

        n0.next = n1;
        n1.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode list = new RemoveDuplicatesInSortedList().deleteDuplicates(n1);
        list.print();

    }
}

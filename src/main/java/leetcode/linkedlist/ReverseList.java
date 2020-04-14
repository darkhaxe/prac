package leetcode.linkedlist;

/**
 * 反转单链表
 *
 * @author haze
 * @date created at 2020/4/12 5:30 下午
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
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
        new ReverseList().reverseList(n1);
    }
}

package leetcode.linkedlist;

/**
 * @author haxe
 * @date created at 2020/4/13 17:28
 */
public class MergeList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;
        new MergeList().mergeTwoLists(n1, n4).print();
    }

    /**
     * 1->2->4
     * 2->3->6
     * 通过递归方式串起两个链表
     * 1   2   4
     * | / | / |
     * 2   3   6
     * 1.定义函数返回值:将两个链表有序合并
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //2.定义结束条件
        //2个链表,当其中一个l1到达结束之处(l1=null),将l2返回作为拼接的结果
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //3.等价关系式
        if (l1.val < l2.val) {
            //l1.val<l2.val,则将l1的下一个元素与l2比较,决定串联方向
            //l1.next接上串联完成的有序新链表
            // Q:为什么不是l2.next接上?
            // A:l1是l1与l2排序得到的有序头结点,l1.next链表进入新的排序比较
            // Q:为什么是return l1?
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}

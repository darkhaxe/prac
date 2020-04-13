package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 * 相交链表
 *
 * @author haze
 * @date created at 2020/4/12 2:51 下午
 */
public class IntersectionLinkedList {

//A:   a1->a2->a3
//               \
//C:              c1->c2->c3
//               /
//B:       b1->b2

    /**
     * 链表A长度=a+c=3+3
     * 链表B长度=b+c=2+3
     * 公共部分链表C长度c=3
     * 遍历2个组合链表同时进行:
     * 组合链表1.A->C->B
     * 组合链表2.B->C->A
     * 如果链表A B相交如上图,则遍历到最后一个元素就是交点
     * 如果链表A 无相交,则最后一个元素都是null,l1==l2=null return null;
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            if (node1 == null) {
                node1 = headB;
            } else {
                node1 = node1.next;
            }


            if (node2 == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }

}

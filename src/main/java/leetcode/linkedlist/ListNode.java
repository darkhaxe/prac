package leetcode.linkedlist;

/**
 * @author haxe
 * @date created at 2020/4/13 17:29
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode tmpNext = next;
        while (tmpNext.next != null) {
            sb.append("->").append(tmpNext.val);
            tmpNext = tmpNext.next;
        }
        System.out.println(sb.toString());
    }
}

package leetcode.other;

import java.util.PriorityQueue;

/**
 * 寻找第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author haze
 * @date created at 2020/4/14 3:44 下午
 */
public class KthElement {
    public static void main(String[] args) {
        System.out.println(
                new KthElement().findKthLargest(
                        new Integer[]{1, 7, 3, 4, 5},
                        2
                )
        );
    }

    public int findKthLargest(Integer[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (k < 0) {
            k = 0;
        }
        //创建小顶堆,当堆size>k,poll堆顶元素,即可将小的元素推出,保持堆中只剩k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : nums) {
            pq.add(val);
            //每次只移除一个元素,可以保证最后只留下k个最大元素
            if (pq.size() > k) {  // 维护堆的大小为 K
                //取出堆顶元素,调整堆
                pq.poll();
            }
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }
}

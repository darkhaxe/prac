package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author haze
 * @date created at 2020/6/2 6:49 上午
 */
public class kthSmallest {
    private int count = 0;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    /**
     * 中序遍历是一个有序数组
     */
    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        count++;

        if (count == k) {
            //满足条件时赋值给res,确保res只赋值一次
            res = root.val;
            return;
        }

        inOrder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode l0 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode root = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        root.left = l0;
        l0.right = l1;
        root.right = l3;
        int val = new kthSmallest().kthSmallest(root, 2);
        System.out.println(val == 2);
    }
}

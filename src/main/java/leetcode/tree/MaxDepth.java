package leetcode.tree;

/**
 * @author haze
 * @date created at 2020/5/28 7:31 上午
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        System.out.println(maxDepth(node3)
        );
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int max = Math.max(l, r) + 1;
        return max;
    }
}


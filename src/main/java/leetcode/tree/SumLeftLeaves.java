package leetcode.tree;

/**
 * @author haxe
 * @date created at 2020/6/3 16:46
 */
public class SumLeftLeaves {
    /**
     * 左叶子:无子树的左节点
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;
        int res = new SumLeftLeaves().sumOfLeftLeaves(l1);
        System.out.println(res);
    }
}

package leetcode.tree;

/**
 * 镜像对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author haxe
 * @date created at 2020/6/2 10:57
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    /**
     * 给定left,right
     * left.left=right.right
     * left.right=right.left
     * 则返回true
     */
    private boolean isSymmetric(TreeNode left,
                                TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);

        TreeNode l4 = new TreeNode(3);
        TreeNode l5 = new TreeNode(2);
        TreeNode l6 = new TreeNode(1);

        TreeNode root = new TreeNode(0);
        root.left = l2;
        root.right = l5;

        l2.left = l1;
        l2.right = l3;

        l5.left = l4;
        l5.right = l6;
        System.out.println(
                new IsSymmetric().isSymmetric(l2)
        );
    }

}

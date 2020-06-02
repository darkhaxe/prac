package leetcode.tree;

/**
 * @author haxe
 * @date created at 2020/6/2 17:20
 */
public class MinDepth {
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
                new MinDepth().minDepth(root)
        );
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //root的左右节点全是空,或一个是空的情况
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        //左右节点都不为空
        //   3
        // 2   4
        //1
        //对于根节点3,min(3,2)+1=2+1=3
        return Math.min(left, right) + 1;
    }
}

package leetcode.tree;

/**
 * 669. 修剪二叉搜索树
 *
 * @author haze
 * @date created at 2020/6/1 12:42 下午
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(5);
        l2.left = l1;
        l2.right = l3;
        l3.right = l4;
        TreeNode node = new TrimBST().trimBST(l2, 1, 2);
        System.out.println(node);
    }
}

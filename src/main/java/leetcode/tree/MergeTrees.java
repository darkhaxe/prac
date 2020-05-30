package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/description/
 *
 * @author haze
 * @date created at 2020/5/28 7:47 上午
 */
public class MergeTrees {
    //          Tree 1                     Tree 2
//             1                         2
//            / \                       / \
//           3   2                     1   3
//          /                           \   \
//         5                             4   7
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(2);
        TreeNode l4 = new TreeNode(5);
        l1.left = l2;
        l1.right = l3;
        l2.left = l4;

        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(7);
        r1.left = r2;
        r1.right = r3;
        r2.right = r4;
        r3.right = r5;

        System.out.println(mergeTrees(l1, r1)
        );
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //2者都为空
        if (t1 == null && t2 == null) {
            return null;
        }
        //2者有一个空
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        //2者都不为空
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;

    }
}

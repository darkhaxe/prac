package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author haxe
 * @date created at 2020/6/2 9:36
 */
public class IsSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(s);
        //遍历一颗树的所有节点(非递归),判断每个节点是否与树t的拓扑结构相同
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isSameTree(node, t)) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

package leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author haxe
 * @date created at 2020/6/2 9:43
 */
public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode l0 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode root = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        root.left = l0;
        l0.right = l1;
        root.right = l3;
        new TreeTraversal().traversal(root);
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> stack = new ArrayDeque<>();

        stack.offer(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.poll();
            System.out.println(node.val);

            if (node.left != null) {
                stack.offer(node.left);
            }


            if (node.right != null) {
                stack.offer(node.right);
            }
        }

    }
}

package leetcode.tree;

import lombok.Data;

/**
 * @author haze
 * @date created at 2020/5/28 7:33 上午
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

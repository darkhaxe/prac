package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * @author haze
 * @date created at 2020/5/28 12:41 下午
 */
public class PathSum {

    public static void main(String[] args) {

    }

    /**
     * 题设:路径和包含根节点,因此使用减法从根开始搜索
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null &&
                root.right == null &&
                root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);

    }
}

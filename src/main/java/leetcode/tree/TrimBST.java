package leetcode.tree;

/**
 * 669. 修剪二叉搜索树
 *
 * @author haze
 * @date created at 2020/6/1 12:42 下午
 */
public class TrimBST {
    /**
     * 从根节点开始,目标区间是[L,R]
     * <p>

     * <p>
     *
     * <p>
     * 当根节点的值在L值与R值中间，则左子树和右子树分别递归修剪
     *
     * @return 递归返回修剪完成的[L, R]之间的子树
     */
    public TreeNode trimBST(TreeNode cur, int min, int max) {
        if (cur == null) {
            return null;
        }
//        当根节点的值大于R值，说明根节点不在区间内,找到小于根节点的节点(左子树小于根节点),递归处理,
//      从起左子树开始递归修剪二叉树
        //此操作相当于移动到更小的节点,
        //此时有两种情况:
//        1.节点为null,说明在这个树上不存在一个节点位于目标区间
        //2.出现一个节点处于[min,max]之间
        if (cur.val > max) {
            return trimBST(cur.left, min, max);
        }
//        当根节点的值小于L值，说明根节点不在区间内,找到大于根节点的节点(右子树大于根节点),递归处理,
//                从其右子树开始递归函数修剪二叉树
        if (cur.val < min) {
            return trimBST(cur.right, min, max);
        }

        //到达目标区间内,处理节点:
        //修剪节点的左子树
        //修剪节点的右子树
        //实际的修剪操作->去除不在[min,max]之间的节点,是第一行if(cur==null) return null;完成的
        //min <= cur.val <= max
        cur.left = trimBST(cur.left, min, max);
        cur.right = trimBST(cur.right, min, max);
        return cur;
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

package leetcode.tree;

/**
 * @author haxe
 * @date created at 2020/5/26 17:15
 */
public class MaxDiameter {
    private int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
//        countEdge(root);
        return max;
    }
//     3
//    / \
//   5   2
//  / \
// 7   9
//[7,5,3,2]-->max=3 最大直径
//最大直径:统计每个节点的边数
//给定节点5 ,左子树边数1,右子树边数1,节点5的子树的直径=2
//给定节点3 ,计算其左子树边数,2种情况边数都是2,因此左子树边数为2,右子树边数1
    /**
     * 给到一个节点root,返回该节点的边长
     * @return
//     */
//    private int countEdge(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//
//        int leftEdgeCount = countEdge(root.left);
//
//        int rightEdgeCount = countEdge(root.right);
//
//        return
//
//    }

    public static void main(String[] args) {

    }
}

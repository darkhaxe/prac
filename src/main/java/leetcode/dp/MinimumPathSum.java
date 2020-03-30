package leetcode.dp;

import java.util.Arrays;

/**
 * 最优路径和
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author haze
 * @date created at 2020/3/30 3:42 下午
 */
public class MinimumPathSum {
    public int solution(int[][] grid) {
        //1.定义dp[][],dp[i][j]表示从(0,0)到(i,j)的最小路径和
        //m x n数组,xy轴角标从0开始,则目标答案=dp[m-1][n-1]

        //2.关系
        //最小路径和=到达上/左一个坐标的最小路径和+坐标(i,j)的值
//        dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]

        //3.寻找,计算初始值
        //i-1>0 j-1>0
        //因此(0,0...n),(0..m,0)的最小路径和都需要初始化
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            //y轴
            //取出第1个元素 数组xArr
            int[] xArr = grid[i];
            //
            if (i == 0) {
                dp[0][0] = xArr[0];
                //x轴
                for (int j = 0; j < xArr.length; j++) {
                    if (j == 0) {
                        dp[0][0] = xArr[0];
                    } else {
                        dp[0][j] = xArr[j] + dp[0][j - 1];
                    }
                }
            } else {
                dp[i][0] = xArr[0] + dp[i - 1][0];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        //变量整个grid,计算dp[][]所有值
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        new MinimumPathSum().solution(A);
    }
}

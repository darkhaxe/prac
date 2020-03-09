package leetcode.graph;

import com.alibaba.fastjson.JSON;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haze
 * @date created at 2020/2/3 8:53 下午
 */
public class PerfectSquares {
    //todo 看不懂 20200204
    public int numSquares(int n) {
//        return dynamicProgress(n);
        //无权图找最短路径解法,使用队列先进先出
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        while (!queue.isEmpty()) {
            //两个数值之间存在一个完全平方数,则添加一条边
            //1和5,给定n=5,在此内循环中,Pair(1,1) Pair(2,3)
            Pair<Integer/* 数值x */, Integer/* 数值x到达给定数值n的最短路径(边的累计) */> front = queue.removeFirst();
            System.out.println("front=" + JSON.toJSONString(front));
            int num = front.getKey();
            int minPath = front.getValue();
            //Q:为什么num=0代表找到最短路径? A:因为minPath记录的是最短路径,因为num=0,代表0->n的minPath已经得出
            //Q:如何理解minPath记录的是最短路径?是如何实现的? A:下面的逻辑实现了:一个数rest到达num的完全平方数个数,只要rest为0,则得到结果
            if (num == 0)
                return minPath;

            int i = 1;
            while (num - i * i >= 0) {
                int rest = num - i * i;
                queue.addLast(new Pair<>(rest, minPath + 1));
                i++;
            }
            System.out.println("num=" + num + " queue=" + JSON.toJSONString(queue));
//            for(int i = 1 ; num - i*i >= 0 ; i ++)
//                queue.addLast(new Pair<>(num - i * i, minPath + 1));
        }

        throw new IllegalStateException("No Solution.");
    }


    /**
     * 动态规划实现
     * 如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x=a+bｘb，
     * 那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1（因为b*b已经是平方数了）。
     */
    private int dynamicProgress(int n) {
        //定义perfectSquareCount[n]->index:目标数值n;数值:最少个完全平方数的个数
        int[] perfectSquareCount = new int[n + 1];
        // 将所有非平方数的结果置最大，保证之后比较的时候不被选中
        Arrays.fill(perfectSquareCount, Integer.MAX_VALUE);
        // 将所有平方数的结果置1
        //perfectSquareCount[1]=1
        //perfectSquareCount[4]=1
        //perfectSquareCount[9]=1
        for (int i = 0; i * i <= n; i++) {
            perfectSquareCount[i * i] = 1;
        }
        // 从小到大找任意数a
        //在a<=n的前提下,递增a
        for (int a = 0; a <= n; a++) {
            System.out.println("----------a=" + a + "-------------");
            // 从小到大找平方数bｘb
            //在a + b * b <= n的前提下,递增b
            for (int b = 0; a + b * b <= n; b++) {
                //perfectSquareCount[a] + 1的含义:n=a+b*b  -->perfectSquareCount(n)=perfectSquareCount(a)+1
                // perfectSquareCount(int x):返回组成x的最少平方数个数
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                //例如:第一次循环 dp[0]=1,todo 补完
                System.out.println("内 perfectSquareCount=" + JSON.toJSONString(perfectSquareCount));
                System.out.println("perfectSquareCount[" + (a + b * b) + "]=min( perfectSquareCount[" + a + "] + 1=" + (perfectSquareCount[a] + 1) + " perfectSquareCount[" + a + " + " + b + "*" + b + "]=" + perfectSquareCount[a + b * b] + "  )");
                perfectSquareCount[a + b * b] = Math.min(perfectSquareCount[a] + 1, perfectSquareCount[a + b * b]);
            }
            System.out.println("----------a=" + a + "-------------");
        }
        System.out.println("perfectSquareCount=" + JSON.toJSONString(perfectSquareCount));

        return perfectSquareCount[n];
    }

    public static void main(String[] args) {

//        System.out.println(new PerfectSquares().numSquares(12));
//        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(new PerfectSquares().numSquares(10));
    }

}

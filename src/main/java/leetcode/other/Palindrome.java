package leetcode.other;

/**
 * https://leetcode-cn.com/problems/palindrome-number/%E3%80%82/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:你能不将整数转为字符串来解决这个问题吗？
 *
 * @author haze
 * @date created at 2020/1/28 5:57 下午
 */
public class Palindrome {

    public boolean isPalindrome(int inputInt) {
        //1.如果为负数,返回
        if (inputInt < 0) {
            return false;
        }
        //2.翻转一个数,相等则返回
        if (inputInt != 0 && inputInt % 10 == 0) {
            return false;
        }

        int reverse = new ReverseInt().reverse(inputInt);
        if (reverse == inputInt) {
            return true;
        }
        return false;
    }
}

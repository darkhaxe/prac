package leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * leetcode#20
 * -- 有效括号
 *
 * @author haze
 * @date created at 2020/2/3 4:42 下午
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        List<Character> open = Arrays.asList('(', '{', '[');
        List<Character> close = Arrays.asList(')', '}', ']');

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();


        for (char c : charArray) {
            if (open.contains(c)) {
                stack.push(c);
            } else {
                //没有开放字符就出现关闭字符,返回false
                if (stack.isEmpty()) {
                    return false;
                }
                //遇到关闭字符就pop一个开始字符,要求两者必须匹配
                Character openChar = stack.pop();
                int index = open.indexOf(openChar);
                Character targetChar = close.get(index);
                if (!Objects.equals(c, targetChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("]"));
        System.out.println(new ValidParentheses().isValid("]]"));
        System.out.println(new ValidParentheses().isValid("("));
        System.out.println(new ValidParentheses().isValid("(("));
        System.out.println(new ValidParentheses().isValid("({})"));
        System.out.println(new ValidParentheses().isValid("({[})]"));
    }
}

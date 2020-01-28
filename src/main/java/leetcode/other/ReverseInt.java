package leetcode.other;

/**
 * 整数反转
 *
 * @author haze
 * @date created at 2020/1/28 6:09 下午
 */
public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(
                new ReverseInt().reverse(3421)
        );
        System.out.println(
                new ReverseInt().reverse(0)
        );
//        2147483647
        System.out.println(
                Integer.MAX_VALUE
        );
//        -2147483648
        System.out.println(
                Integer.MIN_VALUE
        );
    }

    /**
     * rev是循环使用的，每循环一次最后一位就乘以10，并在改数后面拼接上前一位，以此来实现反转。
     * 例如：输入为321,
     * 第一次循环 rev =0, 321的余数pop=1, x除以10后等于32.1，
     * 但因为是整型所以自动舍去后面的小数，inputInt=32, rev = 0*10 + 1 = 1
     * 第二次循环 rev =1，inputInt=32的余数pop=2,x除以10后等于3.2，
     * 但因为是整型所以自动舍去后面的小数，inputInt=3, rev = 1*10 + 2 = 12
     * 第三次循环 rev =12，inputInt=3的余数pop=3,x除以10后等于0.3，
     * 但因为是整型所以自动舍去后面的小数，inputInt=0, rev = 12*10 + 3 = 123
     * *
     * ————————————————
     * 版权声明：本文为CSDN博主「pocher」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/bingxuesiyang/article/details/88690461
     */
    public  int reverse(int inputInt) {
        int reverse = 0;
        while (inputInt != 0) {
            //第1个变量:余数
            int remainder = inputInt % 10;
            //第2个变量:
            inputInt = inputInt / 10;
            // 大于等于Integer的正整数的最大值返回0
            // reverse * 10 + remainder >= 2147483647 (Integer.MAX_VALUE)
            if (reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (reverse == Integer.MAX_VALUE / 10 && remainder > 7) {
                return 0;
            }
            // 小于等于Integer的负整数的最大值返回0
            //reverse * 10 - remainder <= -2147483648 (Integer.MIN_VALUE)
            if (reverse < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if (reverse == Integer.MIN_VALUE / 10 && remainder < -8) {
                return 0;
            }
            //第3个变量
            reverse = reverse * 10 + remainder;
        }
        return reverse;

    }
}

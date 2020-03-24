package algorithm;

/**
 * leetcode#387
 * @author haze
 * @date created at 2020/3/24 8:18 上午
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(
                solution("aac"));

    }

    public static int solution(String s) {
        //初始化一个26字母的频率数组:记录各个字符的出现次数
        int[] alphabetFreq = new int[26];
        //遍历字符串s,统计每个字符(字母)的频率
        for (int i = 0; i < s.length(); i++) {
            alphabetFreq[getAlphabetIndex(s, i)]++;
        }
        //遍历字符串s的每个字符,找到第一个字符频率为1的
        for (int i = 0; i < s.length(); i++) {
            if (alphabetFreq[getAlphabetIndex(s, i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int getAlphabetIndex(String s, int i) {
        return s.charAt(i) - 'a';
    }
}

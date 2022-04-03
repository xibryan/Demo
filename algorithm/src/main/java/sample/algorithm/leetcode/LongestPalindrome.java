package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/longest-palindromic-substring/
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] array = new int[length + 1][length + 1];

        for (int i = 0; i <= length; i++) {
            array[0][i] = 0;
            array[i][0] = 0;
        }

        int maxPos = -1;
        int maxLen = -1;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                int posJ = length + 1 - j;
                if (s.charAt(i - 1) == s.charAt(posJ - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                    if (array[i][j] > maxLen && Math.abs(i - posJ) == array[i][j] - 1) {
                        maxLen = array[i][j];
                        maxPos = i;
                    }
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return s.substring(maxPos - maxLen, maxPos);
    }
}

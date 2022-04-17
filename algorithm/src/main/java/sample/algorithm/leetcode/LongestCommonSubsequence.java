package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/longest-common-subsequence/
1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] p = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            p[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            p[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    p[i][j] = p[i - 1][j - 1] + 1;
                } else {
                    p[i][j] = Math.max(p[i - 1][j], p[i][j - 1]);
                }
            }
        }

        return p[m][n];
    }
}

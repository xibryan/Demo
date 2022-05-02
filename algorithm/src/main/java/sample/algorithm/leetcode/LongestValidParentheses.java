package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/longest-valid-parentheses/submissions/
32. 最长有效括号
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

 

示例 1：

输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] lengthArr = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - lengthArr[i - 1] - 1 >= 0 && s.charAt(i - lengthArr[i - 1] - 1) == '(') {
                lengthArr[i] = lengthArr[i - 1] + 2;
                if (i - lengthArr[i - 1] - 2 >= 0) {
                    lengthArr[i] += lengthArr[i - lengthArr[i - 1] - 2];
                }
                result = Math.max(result, lengthArr[i]);
            }
        }
        return result;
    }
}

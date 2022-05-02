package sample.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int curStart = -1;
        Map<Character, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer prePos = lastPos.get(ch);
            if (prePos != null && prePos > curStart) {
                curStart = prePos;
            }
            lastPos.put(ch, i);
            result = Math.max(i - curStart, result);
        }

        return result;
    }
}

package sample.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode-cn.com/problems/word-break/
139. 单词拆分
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] result = new boolean[s.length() + 1];
        Arrays.fill(result, false);
        result[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] && wordSet.contains(s.substring(j,i))) {
                    result[i] = true;
                    break;
                }
            }
        }

        return result[s.length()];
    }
}

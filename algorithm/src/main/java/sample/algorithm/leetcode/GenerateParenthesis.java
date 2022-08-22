package sample.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.cn/problems/generate-parentheses/
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        Set<String> results = new HashSet<>();
        generateParenthesisI("", n, n, results);
        return new ArrayList<>(results);
    }

    private void generateParenthesisI(String str, int left, int right, Set<String> results) {
        if (left == 0 && right == 0) {
            results.add(str);
            return;
        }
        if (left > 0) {
            generateParenthesisI(str + "(", left - 1, right, results);
        }
        if (right > left) {
            generateParenthesisI(str + ")", left, right - 1, results);
        }
    }
}

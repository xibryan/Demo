package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    @Test
    void longestValidParentheses() {
        int result = new LongestValidParentheses().longestValidParentheses(")()())");
        System.out.println(result);
    }
}
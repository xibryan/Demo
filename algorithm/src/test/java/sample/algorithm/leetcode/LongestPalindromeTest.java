package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        String result = new LongestPalindrome().longestPalindrome("babad");
        System.out.println(result);
    }

    @Test
    void longestPalindrome1() {
        String result = new LongestPalindrome().longestPalindrome("aacabdkacaa");
        System.out.println(result);
    }
}
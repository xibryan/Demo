package sample.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode-cn.com/problems/longest-consecutive-sequence/
128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int cnt = 1;
            for (; set.contains(num + cnt); cnt++) ;
            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}

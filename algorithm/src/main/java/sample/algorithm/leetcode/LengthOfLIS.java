package sample.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长上升子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int[] lis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[i] = max;
            maxLength = Math.max(maxLength, max);
        }

        return maxLength;
    }
}

package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/house-robber/submissions/
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        int max = result[1];

        for (int i = 2; i < nums.length ; i++) {
            result[i] = Math.max(result[i-1], result[i-2] + nums[i]);
            max = Math.max(max, result[i]);
        }

        return max;
    }
}

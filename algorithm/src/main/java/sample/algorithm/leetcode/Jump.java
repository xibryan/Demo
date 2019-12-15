package sample.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 */
public class Jump {
    public int jump(int[] nums) {
        int numOfJumps[] = new int[nums.length];
        Arrays.fill(numOfJumps, Integer.MAX_VALUE);
        numOfJumps[0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int curNum = numOfJumps[i];
            int curJump = nums[i];
            for (int j = 1; j <= curJump; j++) {
                numOfJumps[i+j] = Math.min(curNum + 1, numOfJumps[i+j]);
                if (i+j == nums.length -1) {
                    return numOfJumps[i+j];
                }
            }
        }

        return numOfJumps[numOfJumps.length-1];
    }
}

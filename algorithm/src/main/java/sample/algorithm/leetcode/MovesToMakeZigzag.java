package sample.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag/
 * 1144. 递减元素使数组呈锯齿状
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int sum1 = 0;
        int sumOdd = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum1 += numOfOperation(nums, i);
        }


        for (int i = 1; i < nums.length; i += 2) {
            sumOdd += numOfOperation(nums, i);
        }

        return (sum1 < sumOdd) ? sum1 : sumOdd;
    }

    private int numOfOperation(int[] nums, int i) {
        int currentValue = nums[i];
        int minValue = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            int leftValue = nums[i - 1];
            if (leftValue < minValue) {
                minValue = leftValue;
            }
        }

        if (i + 1 < nums.length) {
            int rightValue = nums[i + 1];
            if (rightValue < minValue) {
                minValue = rightValue;
            }
        }

        int numOfOperation = 0;
        if (minValue <= currentValue) {
            numOfOperation = currentValue - minValue + 1;
        }

        return numOfOperation;
    }
}

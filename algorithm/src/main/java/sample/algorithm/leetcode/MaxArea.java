package sample.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;

        while (leftIdx < rightIdx) {
            if(height[leftIdx] <= maxLeft) {
                leftIdx++;
                continue;
            }

            if (height[rightIdx] <= maxRight) {
                rightIdx--;
                continue;
            }

            int curArea = 0;
            int curLeft = height[leftIdx];
            int curRight = height[rightIdx];
            if (curLeft < curRight) {
                curArea = curLeft * (rightIdx-leftIdx);
                leftIdx++;
            }
            else {
                curArea = curRight * (rightIdx-leftIdx);
                rightIdx --;
            }

            max = Math.max(max, curArea);
        }

        return max;
    }
}

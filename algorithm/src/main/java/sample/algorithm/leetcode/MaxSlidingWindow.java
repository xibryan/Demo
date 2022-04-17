package sample.algorithm.leetcode;

import javafx.util.Pair;

import java.util.PriorityQueue;

/*
https://leetcode-cn.com/problems/sliding-window-maximum/
239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(
                (x, y) -> (x[0] == y[0]) ? Integer.compare(y[1], x[1]) : Integer.compare(y[0], x[0]));

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }

        for (int i = k - 1; i < nums.length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            int[] curMax = priorityQueue.peek();
            while (curMax[1] <= i - k) {
                priorityQueue.poll();
                curMax = priorityQueue.peek();
            }
            result[i - k + 1] = curMax[0];
        }

        return result;
    }
}

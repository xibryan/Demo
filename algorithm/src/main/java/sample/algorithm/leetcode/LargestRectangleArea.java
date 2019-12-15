package sample.algorithm.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            int previous = stack.peek();
            while (previous >= 0 && heights[previous] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.get(stack.size() - 1) - 1;
                maxArea = Math.max(maxArea, width * height);
                previous = stack.peek();
            }

            stack.push(i);
        }

        while (stack.peek() >= 0) {
            int previous = stack.pop();
            int height = heights[previous];
            int width = heights.length - stack.get(stack.size() - 1) - 1;
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}

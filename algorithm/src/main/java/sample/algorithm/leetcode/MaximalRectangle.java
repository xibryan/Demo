package sample.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * 85. 最大矩形
 */
public class MaximalRectangle {
    // 每个节点保存所有满足条件的矩阵
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int height = matrix.length;
        int width = matrix[0].length;

        int[] maxHeights = new int[width];
        int[] minLefts = new int[width];
        int[] maxRights = new int[width];

        Arrays.fill(maxHeights, 0);
        Arrays.fill(minLefts, 0);
        Arrays.fill(maxRights, width - 1);

        int maxRectangle = 0;
        for (int i = 0; i < height; i++) {
            int left = 0;
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '1') {
                    maxHeights[j] = maxHeights[j] + 1;
                    minLefts[j] = (maxHeights[j] > 1) ? Math.max(minLefts[j], left) : left;
                } else {
                    left = j + 1;
                    maxHeights[j] = 0;
                }
            }

            int right = width - 1;
            for (int j = width - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    maxRights[j] = (maxHeights[j] > 1) ? Math.min(maxRights[j], right) : right;
                    maxRectangle = Math.max(maxRectangle, maxHeights[j] * (maxRights[j] - minLefts[j] + 1));
                } else {
                    right = j - 1;
                }
            }
        }

        return maxRectangle;
    }
}

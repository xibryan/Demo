package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/sort-an-array/
912. 排序数组
给你一个整数数组 nums，请你将该数组升序排列。
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length / 2; i > 0; i--) {
            adjustTree(nums, nums.length, i);
        }

        for (int i = nums.length; i > 1; i--) {
            swap(nums, 1, i);
            adjustTree(nums, i - 1, 1);
        }

        return nums;
    }

    private void adjustTree(int[] nums, int length, int pos) {
        int curPos = pos;
        int leftChild = 2 * pos;
        while (leftChild <= length) {
            int biggerChild = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild <= length && nums[rightChild - 1] > nums[leftChild - 1]) {
                biggerChild = rightChild;
            }

            if (nums[biggerChild - 1] <= nums[curPos - 1]) {
                break;
            }

            swap(nums, curPos, biggerChild);
            curPos = biggerChild;
            leftChild = 2 * curPos;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = tmp;
    }
}

package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
215. 数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class TopK {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        int idx = partition(nums, start, end);
        if (k == idx) {
            return nums[idx];
        } else if (k < idx) {
            return quickSelect(nums, start, idx - 1, k);
        } else {
            return quickSelect(nums, idx + 1, end, k);
        }
    }

    public int partition(int[] nums, int start, int end) {
        if (end - start > 10) {
            selectP(nums, start, end);
        }
        int pIdx = start;
        int p = nums[pIdx];
        while (start < end) {
            for (; start < end && nums[end] <= p; end--) ;
            for (; start < end && nums[start] >= p; start++) ;
            if (start != end) {
                this.swap(nums, start, end);
            }
        }
        if (end != pIdx) {
            swap(nums, end, pIdx);
        }
        return end;
    }

    private void selectP(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        if (nums[start] < nums[middle] && nums[middle] < nums[end]) {
            swap(nums, start, middle);
        } else if (nums[start] > nums[middle] && nums[middle] > nums[end]) {
            swap(nums, start, middle);
        } else if (nums[start] < nums[end] && nums[end] < nums[middle]) {
            swap(nums, start, end);
        } else if (nums[start] > nums[end] && nums[end] > nums[middle]) {
            swap(nums, start, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

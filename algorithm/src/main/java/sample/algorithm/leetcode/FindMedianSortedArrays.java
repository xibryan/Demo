package sample.algorithm.leetcode;

/*
https://leetcode.cn/problems/median-of-two-sorted-arrays/
4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。
 */

// todo
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        boolean even = (length1 + length2) % 2 == 0;
        int middleIdx = (length1 + length2) / 2;
        int middleIdx1 = even ? middleIdx - 1 : -1;

        int start1 = 0, end1 = nums1.length - 1, start2 = 0, end2 = nums2.length - 1;
        while (start1 < end1 && start2 < end2) {
            int idx1 = (start1 + end1) / 2;
            int idx2 = (start2 + end2) / 2;
            int tmp1 = nums1[idx1], tmp2 = nums2[idx2];

            if (tmp1 < tmp2) {
                start1 = tmp1;
                end2 = tmp2;
            } else {
                end2 = tmp1;
                start2 = tmp2;
            }
        }

        return 0;
    }
}

package sample.algorithm.leetcode;

public class Lc_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int numOfMedian = (length % 2 == 0) ? 2 : 1;
        int idxOfMedian = length / 2;

        int idx1 = idxOfMedian;
        int idx2 = idxOfMedian;

        while (idx1 < nums1.length && idx2 < nums2.length) {

        }
    }
}

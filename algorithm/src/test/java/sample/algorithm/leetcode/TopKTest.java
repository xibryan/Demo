package sample.algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKTest {

    @Test
    void findKthLargest() {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int kthLargest = new TopK().findKthLargest(arr, 4);
        Assert.assertEquals(4, kthLargest);
    }
}
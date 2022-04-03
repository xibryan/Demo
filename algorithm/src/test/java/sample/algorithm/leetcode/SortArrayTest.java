package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {

    @Test
    void sortArray() {
        int[] test = {-2,3,-5};
        new SortArray().sortArray(test);
        System.out.println(Arrays.toString(test));
    }
}
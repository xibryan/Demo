package sample.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class HeapSortTest
{
    @Test
    public void test()
    {
        int[] data = { 1, 45, 65, 4, 5, 98, 7 };
        System.out.println(Arrays.toString(data));
        HeapSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}

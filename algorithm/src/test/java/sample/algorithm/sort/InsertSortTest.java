package sample.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class InsertSortTest
{
    @Test
    public void test()
    {
        int[] data = { 2, 1, 45, 65, 4, 5, 98, 7 };
        System.out.println(Arrays.toString(data));
        InsertSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}

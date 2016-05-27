package sample.algorithm.search;

import org.junit.Test;

public class BinarySearchTest
{
    @Test
    public void test()
    {
        int[] data = { 1, 3, 5, 6, 7, 8, 12, 26, 28, 34, 38, 59 };
        int ret = BinarySearch.search(data, 7);
        System.out.println(ret);

        ret = BinarySearch.search(data, 38);
        System.out.println(ret);

        ret = BinarySearch.search(data, 39);
        System.out.println(ret);
    }
}

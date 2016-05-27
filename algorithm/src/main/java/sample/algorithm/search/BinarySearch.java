package sample.algorithm.search;

public class BinarySearch
{
    public static int search(int[] data, int target)
    {
        return binarySearch(data, target, 1, data.length);
    }

    private static int binarySearch(int[] data, int target, int begin, int end)
    {
        if (begin > end)
        {
            return -1;
        }

        int middle = (begin + end) / 2;
        if (data[middle - 1] == target)
        {
            return middle - 1;
        }
        else if (data[middle - 1] > target)
        {
            return binarySearch(data, target, begin, middle - 1);
        }
        else
        {
            return binarySearch(data, target, middle + 1, end);
        }
    }
}

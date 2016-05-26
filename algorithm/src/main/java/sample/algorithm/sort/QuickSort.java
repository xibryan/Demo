package sample.algorithm.sort;

public class QuickSort
{
    public static void sort(int[] data)
    {
        quickSort(data, 1, data.length);
    }

    private static void quickSort(int[] data, int start, int end)
    {
        if (start < end)
        {
            selectBaseNumber(data, start, end);
            int pos = partition(data, start, end);
            quickSort(data, start, pos - 1);
            quickSort(data, pos + 1, end);
        }
    }

    // 选择数组开头、结尾和中间的三个数中中间的数作为基准排序
    private static void selectBaseNumber(int[] data, int start, int end)
    {
        int pos = 0;
        int middle = (start + end) / 2;
        int startNum = data[start - 1], endNum = data[end - 1], middleNum = data[middle - 1];
        if (startNum > endNum)
        {
            pos = (endNum > middleNum) ? end : ((startNum > middleNum) ? middle : start);
        }
        else
        {
            // i <= j
            pos = (endNum < middleNum) ? end : ((startNum < middleNum) ? middle : start);
        }

        if (pos != end)
        {
            swap(data, pos, end);
        }
    }

    private static int partition(int[] data, int start, int end)
    {
        int base = data[end - 1];
        int i = start, j = end - 1;
        while (i <= j)
        {
            if (data[i - 1] <= base)
            {
                ++i;
                continue;
            }

            if (data[j - 1] >= base)
            {
                --j;
                continue;
            }

            if (i < j)
            {
                swap(data, i, j);
            }
        }

        swap(data, i, end);
        return i;
    }

    private static void swap(int[] data, int i, int j)
    {
        int tmp = data[i - 1];
        data[i - 1] = data[j - 1];
        data[j - 1] = tmp;
    }
}

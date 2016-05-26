package sample.algorithm.sort;

public class MergeSort
{
    public static void sort(int[] data)
    {
        sort(data, 1, data.length);
    }

    private static void sort(int[] data, int start, int end)
    {
        if (start >= end)
        {
            return;
        }

        int middle = (start + end) / 2;
        sort(data, start, middle);
        sort(data, middle + 1, end);
        merge(data, start, middle, end);
    }

    private static void merge(int[] data, int start, int middle, int end)
    {
        int[] tmp = new int[end - start + 1];
        int idxTmp = 0;
        int left = start, right = middle + 1;
        while (left <= middle || right <= end)
        {
            if (left > middle)
            {
                tmp[idxTmp++] = data[right++ - 1];
                continue;
            }

            if (right > end)
            {
                tmp[idxTmp++] = data[left++ - 1];
                continue;
            }

            if (data[left - 1] < data[right - 1])
            {
                tmp[idxTmp++] = data[left++ - 1];
            }
            else
            {
                tmp[idxTmp++] = data[right++ - 1];
            }
        }

        for (int j2 = 0; j2 < tmp.length; j2++)
        {
            data[start + j2 - 1] = tmp[j2];
        }
    }
}

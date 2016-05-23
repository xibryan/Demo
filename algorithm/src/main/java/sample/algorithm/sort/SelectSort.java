package sample.algorithm.sort;

public class SelectSort
{
    public static void sort(int[] data)
    {
        for (int i = data.length - 1; i > 0; i--)
        {
            int max = data[i];
            int indexMax = i;

            for (int j = i - 1; j >= 0; j--)
            {
                int tmp = data[j];
                if (tmp > max)
                {
                    max = tmp;
                    indexMax = j;
                }
            }

            if (indexMax != i)
            {
                data[indexMax] = data[i];
                data[i] = max;
            }
        }
    }
}

package sample.algorithm.sort;

//冒泡排序
public class BubbleSort
{
    public static void sort(int[] data)
    {
        for (int i = data.length; i > 1; i--)
        {
            for (int j = 1; j < i; j++)
            {
                if (data[j - 1] > data[j])
                {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] data, int i, int j)
    {
        int tmp = data[i - 1];
        data[i - 1] = data[j - 1];
        data[j - 1] = tmp;
    }
}

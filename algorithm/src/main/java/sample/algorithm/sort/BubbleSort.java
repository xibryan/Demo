package sample.algorithm.sort;

//冒泡排序
public class BubbleSort
{
    public static void sort(int[] data)
    {
        for (int i = data.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (data[j] > data[j + 1])
                {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}

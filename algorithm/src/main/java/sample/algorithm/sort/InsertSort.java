package sample.algorithm.sort;

public class InsertSort {
    public static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    data[j + 1] = value;
                    break;
                }
            }
            if (j < 0) {
                data[j + 1] = value;
            }
        }
    }
}

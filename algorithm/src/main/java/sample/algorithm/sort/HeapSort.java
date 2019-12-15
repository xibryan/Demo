package sample.algorithm.sort;

public class HeapSort {
    public static void sort(int[] data) {
        initHeap(data);
        for (int length = data.length; length > 1; length--) {
            swap(data, 1, length);
            adjustHeap(data, length - 1, 1);
        }
    }

    private static void initHeap(int[] data) {
        for (int i = data.length / 2; i > 0; i--) {
            adjustHeap(data, data.length, i);
        }
    }

    private static void adjustHeap(int[] data, int length, int index) {
        int curNode = index;
        while (2 * curNode <= length) {
            int biggerChild = 2 * curNode;
            if ((biggerChild + 1 <= length) && (data[biggerChild] > data[biggerChild - 1])) {
                biggerChild = biggerChild + 1;
            }

            if (data[biggerChild - 1] > data[curNode - 1]) {
                swap(data, curNode, biggerChild);
                curNode = biggerChild;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i - 1];
        data[i - 1] = data[j - 1];
        data[j - 1] = tmp;
    }
}

package Algorithm;

import java.util.Random;

public class QSort {
    public static int ARRAY_LENGTH = 30;
    private static int[] array = new int[ARRAY_LENGTH];
    private static Random generator = new Random();

    public static void initArray() {
        for (int i=0; i<ARRAY_LENGTH; i++) {
            array[i] = generator.nextInt(100);
        }
    }

    public static void printArray() {
        for (int i=0; i<ARRAY_LENGTH-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[ARRAY_LENGTH-1]);
    }

    public static void quickSort() {
        int startIndex = 0;
        int endIndex = ARRAY_LENGTH - 1;
        doSort(startIndex, endIndex);
    }

    private static void swap(int i, int j) {
        int changer = array[i];
        array[i] = array[j];
        array[j] = changer;
    }

    private static void doSort(int start, int end) {
        int i = start;
        int j = end;
        int pivot = (i + j) / 2;
        while (i < j) {
            while (i < pivot && array[i] <= array[pivot]) {
                i++;
            }
            while (j > pivot && array[pivot] <= array[j]) {
                j--;
            }
            if (i < j) {
                swap(i, j);
                if (i == pivot)
                    pivot = j;
                if (j == pivot) {
                    pivot = i;
                }
            }
            doSort(start, pivot);
            doSort(pivot+1, end);
        }
    }

    public static void main(String[] args) {
        initArray();
        printArray();
        quickSort();
        printArray();
    }
}

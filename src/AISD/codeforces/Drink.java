package AISD.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Drink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mag = new int[n];
        for (int i = 0; i < n; i++) {
            mag[i] = scanner.nextInt();
        }
        Arrays.sort(mag);
        int m = scanner.nextInt();
        int[] cost = new int[m];
        for (int i = 0; i < m; i++) {
            cost[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.binarySearch(mag, cost[i]));
        }
    }

//    public static int binar(int[] arr, int value) {
//        int start = 0;
//        int end = arr.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (arr[mid] > value) {
//                end = mid - 1;
//            }
//            else  {
//                start = mid + 1;
//            }
//
//        }
//        return start;
//    }
}



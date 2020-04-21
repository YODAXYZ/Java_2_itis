package AISD.codeforces;

import java.util.*;

public class PlayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        arr[0] = a1 * a2;
        for (int i = 1; i < n; i++) {
            int a3 = scanner.nextInt();
            int a4 = scanner.nextInt();
            arr[i] = arr[i - 1] + a3 * a4;
        }

        for (int i = 0; i < m; i++) {
            int val = scanner.nextInt();
            System.out.print(binary(arr, val) + 1 + "\n");
        }

    }

    public static int binary(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < value) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }
}

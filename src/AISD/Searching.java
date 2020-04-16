//package AISD;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Searching {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        Arrays.sort(arr);
//
//        int m = scanner.nextInt();
//        int[] mrr = new int[m];
//        for (int i = 0; i < m; i++) {
//            mrr[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i < m; i++) {
//            int ans = 0;
//            for (int j = 0; j < n; j++) {
//                if (mrr[i] > arr[j]) {
//                    ans++;
//                }
//            }
//            System.out.print(ans + " ");
//        }
//    }
//}

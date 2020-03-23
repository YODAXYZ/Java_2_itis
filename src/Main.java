import Map.HashMap;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void X(int[][] arr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] *= arr[i][j];
            }
        }
    }

    public static void cout (int[][] arr){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void T(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               arr[i][j] = arr[j][i];
            }
        }
    }


    public static void main(String[] args) {
        Random rand = new Random();
        int[][] arr = new int[10][10];
        int[][] arr2 = new int[10][10];
        int[][] arr3 = new int[10][10];


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int value = rand.nextInt(100);
                arr[i][j] = value;
                int value2 = rand.nextInt(10);
                arr2[i][j] = value2;
                int value3 = rand.nextInt(10);
                arr3[i][j] = value3;
            }
        }

        int ans_arr = 0;
        int ans_arr2 = 0;
        int ans_arr3 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    ans_arr += arr[i][j];
                    ans_arr2 += arr2[i][j];
                    ans_arr3 += arr3[i][j];
                }
            }
        }

        int[] ans = new int[]{ans_arr, ans_arr2, ans_arr3};

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        hmap.insert(1, ans_arr);
        hmap.insert(2, ans_arr2);
        hmap.insert(3, ans_arr3);

        if (ans_arr > ans_arr2 && ans_arr > ans_arr3) {
            X(arr);
        }

        if (ans_arr2 > ans_arr && ans_arr2 > ans_arr3) {
            X(arr2);
        }

        if (ans_arr3 > ans_arr2 && ans_arr3 > ans_arr) {
            X(arr3);
        }

        if (ans_arr < ans_arr2 && ans_arr < ans_arr3) {
            T(arr);
        }

        if (ans_arr2 < ans_arr && ans_arr2 < ans_arr3) {
            T(arr2);
        }

        if (ans_arr3 < ans_arr2 && ans_arr3 < ans_arr) {
            T(arr3);
        }

    }
}
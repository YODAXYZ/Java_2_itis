// package AISD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Flot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);
        deleteFlot(arrayList);
    }
    private static void deleteFlot(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        if (size % 2 == 1) {
            System.out.print(arrayList.get(size / 2) + " ");
            arrayList.remove(size / 2);
            deleteFlot(arrayList);
        }
        if (size % 2 == 0) {
            double min_value = Math.min(arrayList.get(size / 2), arrayList.get((size / 2) - 1));
            int min_pos = 0;
            if (min_value == arrayList.get(size / 2)) {
                min_pos = size / 2;
            } else {
                min_pos = (size / 2) - 1;
            }
            System.out.print(arrayList.get(min_pos) + " ");
            arrayList.remove(min_pos);
            deleteFlot(arrayList);
        }
    }
}

package AISD;

import java.util.ArrayList;

public class MergeSimple {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr2 = new int[]{2, 2, 5};

        ArrayList<Integer> ans = merge(arr, arr2);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static ArrayList<Integer> merge(int[] arr, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            arrayList2.add(arr[2]);
        }

        if (arrayList.get(0) == arrayList2.get(0)) {
            ans.add(arrayList.get(0));
        }

        if (arrayList.size() >= arrayList2.size()) {
            int j = 0;
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) > arrayList2.get(j)) {
                    j++;
                    i--;
                }
                if (arrayList.get(i) == arrayList2.get(j)) {
                    ans.add(arrayList.get(i));
                }
            }
        }

        if (arrayList.size() < arrayList2.size()) {
            int j = 0;
            for (int i = 1; i < arrayList2.size(); i++) {
                if (arrayList2.get(i) > arrayList.get(j)) {
                    j++;
                    i--;
                }
                if (arrayList2.get(i) == arrayList.get(j)) {
                    ans.add(arrayList2.get(i));
                }
            }
        }
        return ans;
    }
}

//package AISD.codeforces.level_2.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Birja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short a = scanner.nextShort();
        short b = scanner.nextShort();
        HashMap<Integer, Integer> B = new HashMap<>();
        HashMap<Integer, Integer> S = new HashMap<>();
        ArrayList<Integer> keysB = new ArrayList<>();
        ArrayList<Integer> keysS = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            String dir = scanner.next();
            if (dir.equals("B")) {
                int d = scanner.nextInt();
                int e = scanner.nextInt();
                if (B.containsKey(d)) {
                    e += B.get(d);
                }
                B.put(d, e);
                if (!keysB.contains(d)) {
                    keysB.add(d);
                }
            }
            if (dir.equals("S")) {
                int d = scanner.nextInt();
                int e = scanner.nextInt();
                if (S.containsKey(d)) {
                    e += S.get(d);
                }
                S.put(d, e);
                if (!keysS.contains(d)) {
                    keysS.add(d);
                }
            }
        }
        Smethod(S, keysS, b);
        Bmethod(B, keysB, b);
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int saveI = 0;
        int saveJ = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    saveI = list.get(i);
                    saveJ = list.get(j);
                    list.set(i, saveJ);
                    list.set(j, saveI);
                }
            }
        }
    }

    public static void Bmethod(HashMap<Integer, Integer> N, ArrayList<Integer> I, short b) {
        bubbleSort(I);
        ArrayList<Integer> newKeys = new ArrayList<>();
        if (I.size() < b) {
            for (int i = I.size() - 1; i >- 1; i--) {
                newKeys.add(I.get(i));
            }
            for (int j = 0; j < newKeys.size(); j++) {
                if (N.containsKey(newKeys.get(j))) {
                    System.out.println("B " + newKeys.get(j) + " " + N.get(newKeys.get(j)));
                }
            }
        }
        else  {
            for (int i = I.size() - 1; i > I.size() - 1 - b; i--) {
                newKeys.add(I.get(i));
            }
            for (int j = 0; j < newKeys.size(); j++) {
                if (N.containsKey(newKeys.get(j))) {
                    System.out.println("B " + newKeys.get(j) + " " + N.get(newKeys.get(j)));
                }
            }
        }
    }

    public static void Smethod(HashMap<Integer, Integer> M, ArrayList<Integer> J, short b) {
        bubbleSort(J);
        ArrayList<Integer> newKeys = new ArrayList<>();
        if (J.size() < b) {
            for (int i = 0; i < J.size(); i++) {
                newKeys.add(J.get(i));
            }
            for (int j = newKeys.size() - 1; j > -1; j--) {
                if (M.containsKey(newKeys.get(j))) {
                    System.out.println("S " + newKeys.get(j) + " " + M.get(newKeys.get(j)));
                }
            }
        }
        else {
            for (int i = 0; i < b; i++) {
                newKeys.add(J.get(i));
            }
            for (int j = newKeys.size() - 1; j > -1; j--) {
                if (M.containsKey(newKeys.get(j))) {
                    System.out.println("S " + newKeys.get(j) + " " + M.get(newKeys.get(j)));
                }
            }
        }
    }
}

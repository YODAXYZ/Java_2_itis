package AISD.codeforces;

import java.util.*;

public class Millioner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();

        List<Float> arrayList = new ArrayList<>();
        HashMap<Float, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int p = scanner.nextInt();

            float vec = (float) Math.sqrt(x * x + y * y);

            if(!arrayList.contains(vec))
                arrayList.add(vec);
            if(hashMap.containsKey(vec))
            {
                hashMap.put(vec, hashMap.get(vec) + p);
            }
            else
            {
                hashMap.put(vec, p);
            }
        }

        Collections.sort(arrayList);
        float r = 0;

        for (float a : arrayList) {
            int val = hashMap.get(a);
            s += val;

            if (s >= 1000000) {
                r = a;
                break;
            }
        }

        if (s < 1000000) {
            System.out.println("-1");
        }
        else {
            System.out.println(r);
        }
    }
}

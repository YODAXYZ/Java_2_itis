package AISD.codeforces;

import java.util.Scanner;

public class Lighthouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int N = 1000001;
        int[] lh = new int[N];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            lh[a] = b;
        }

        if (lh[0] > 0) {
            lh[0] = 1;
        }
        int count = 0;

        for(int i=1;i<N;i++){

            int l = 0;
            if (lh[i] < i) {
                 l = lh[i - lh[i] - 1];

            }

            if(lh[i] < i && lh[i] > 0) {
                lh[i] = l + 1;
            }
            else if (lh[i] < i && lh[i] != 0) {
                lh[i] = l;
            }

            else{
                if(lh[i] == 0){
                    lh[i] = lh[i - 1];
                }
                else {
                    lh[i] = 1;
                }
            }

            count=Math.max(count, lh[i]);
        }
        System.out.println(n - count);
    }
}

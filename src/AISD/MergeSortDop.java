package AISD;

public class MergeSortDop {
    public static void main(String[] args) {
        int[] a = {5, 2, 4};
        int[] buffer = new int[a.length];
        mergesort(a, buffer, a.length);
        cout(buffer);
    }

    public static void mergesort (int[] a, int[] b, int num)
    {
        int rght, rend;
        int i,j,m;

        for (int k=1; k < num; k *= 2 ) {
            for (int left=0; left+k < num; left += k*2 ) {
                rght = left + k;
                rend = rght + k;

                if (rend > num) rend = (int) num;

                m = left; i = left; j = rght;

                while (i < rght && j < rend) {
                    if (a[i] <= a[j]) {
                        b[m] = a[i]; i++;
                    }
                    else {
                        b[m] = a[j]; j++;
                    }
                    m++;
                }

                while (i < rght) {
                    b[m]=a[i];
                    i++; m++;
                }

                while (j < rend) {
                    b[m]=a[j];
                    j++; m++;
                }

                for (m=left; m < rend; m++) {
                    a[m] = b[m];
                }
            }
        }
    }

    public static void cout (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

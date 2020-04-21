package AISD;
// O(n*log(n))
import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 20, 5, 6};
        merge(arr, 0, arr.length - 1);
        cout(arr);
    }
    public static void merge(int[] arr, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        merge(arr, low, mid);
        merge(arr, mid + 1, high);

        int[] buffer = Arrays.copyOf(arr, arr.length);

        for (int k = low; k <= high; k++) {
            buffer[k] = arr[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {

            if (i > mid) {
                arr[k] = buffer[j];
                j++;
            }
            else if (j > high) {
                arr[k] = buffer[i];
                i++;
            }
            else if (buffer[j] < buffer[i]) {
                arr[k] = buffer[j];
                j++;
            }
            else {
                arr[k] = buffer[i];
                i++;
            }
        }
    }
    public static void cout (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

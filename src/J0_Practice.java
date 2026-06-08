import java.util.Arrays;
import java.util.Random;

public class J0_Practice {

    static Random random = new Random();

    public static void main(String[] args) {

        for (int test = 1; test <= 1_000_00000; test++) {

            int size = random.nextInt(19) + 2;

            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(20);
            }

            int[] copy = arr.clone();

            int pivotIndex = myPartition(copy);

            if (!isValidPartition(copy, pivotIndex)) {

                System.out.println("FAILED");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(copy));
                System.out.println("pivot=" + pivotIndex);

                return;
            }
        }

        System.out.println("PASSED 1,000,000 TESTS");
    }

    static boolean isValidPartition(int[] arr, int pivotIndex) {

        int pivot = arr[pivotIndex];

        for (int i = 0; i < pivotIndex; i++) {
            if (arr[i] > pivot) {
                return false;
            }
        }

        for (int i = pivotIndex + 1; i < arr.length; i++) {
            if (arr[i] <= pivot) {
                return false;
            }
        }

        return true;
    }
    static int myPartition(int[] arr) {

        if (arr.length <= 1) {
            return 0;
        }

        int pivot = arr[arr.length - 1];

        int i = 0;
        int j = arr.length - 2;

        while (i < j) {

            if (arr[i] <= pivot) {
                i++;
            } else {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j--;
            }
        }

        if (arr[i] <= pivot) {
            i++;
        }

        int temp = arr[i];
        arr[i] = pivot;
        arr[arr.length - 1] = temp;

        return i;
    }
}
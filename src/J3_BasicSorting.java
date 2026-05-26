import java.util.Arrays;

public class J3_BasicSorting {
    static void main() {
        int[] arr= {2,4,1,6,3,5,7,8,4,5,12,34,54,13,6,7,88,4,34,56,99,77};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{2, 4, 1, 6, 3, 5, 7, 8, 4, 5, 12, 34, 54, 13, 6, 7, 88, 4, 34, 56, 99, 77};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{299, 4, 1, 6, 3, 5, 7, 8, 4, 5, 12};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));


    }
    static void bubbleSort( int[] arr){ //O(n^2)swap adjacent: bigger pops to end
        int n = arr.length-1;
        boolean swapped = true;
        int temp;
        for (int i = 0; i<n; i++) {
            if(!swapped){
                break;
            }
                swapped =false;
            for (int j = 0; j < n-i; j++) {
                if(arr[j]>arr[j+1]){
                     temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;

                }
            }
        }
    }
    static void selectionSort(int[] arr){ //0(n^2)find smallest and place at its final index
        int n = arr.length;
        int smallest;
        int temp;
        int k=0;

        while (k<n-1){ //JIT compiler optimization hence n-1 calculation doesn't happen everytime
            smallest = k;
            for (int i = 1+k; i < n; i++) {
                if(arr[i]<arr[smallest]){
                    smallest = i;
                }
            }
            temp = arr[smallest];
            arr[smallest] = arr[k];
            arr[k] = temp;
            k++;

        }


    }
    static void insertionSort(int[] arr){ //0(n^2)place next element in correct position of sorted array part
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i-1;




                   while (j>=0 && arr[j]>temp){
                       arr[j+1] = arr[j];
                       j--;
                   }
                  arr[j+1] = temp;

        }








    }
}

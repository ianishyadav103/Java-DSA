import java.util.Arrays;

public class J0_Practice {
    static void main() {
    int[] arr = {5,4,3,6,1};
//    merge(arr,3,4,4);

        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));


    }
    static void mergeSort(int[] arr,int low,int high){
        if (low<high){
            int mid = (low + high+1)/2;

            mergeSort(arr,low,mid-1);
            mergeSort(arr,mid,high);

           merge(arr,low,mid,high);

        }
    }

    static void merge(int[] arr, int low,int mid, int high){
        int left = low;
        int right = mid;
        int[] temp = new int[high-low+1];
        int k=0;
        while (left < mid && right<=high){
            if (arr[left]<arr[right]){
                temp[k++] = arr[left++];
            }
            else {
                temp[k++] = arr[right++];
            }
        }
        while (left<mid){
            temp[k++] = arr[left++];
        }
        while (right<=high){
            temp[k++] = arr[right++];

        }
        k=0;
        for (int i = low; i <= high; i++) {
            arr[i] = temp[k++];
        }
    }

}



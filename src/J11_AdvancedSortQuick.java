import java.util.Arrays;

public class J11_AdvancedSortQuick {
    static void main() {
        //Quick Sort: TC: 0(n^2) SC: O(log n), Stable: No

        int[] arr = {8,3,7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


}
static void quickSort(int[] arr,int low, int high){
        if (low<high){
            int mid = myPartitionAlgo(arr,low,high);
            quickSort(arr,low,mid-1);
            quickSort(arr,mid+1,high);
        }
}

static int myPartitionAlgo(int[] arr,int low,int high){
        //below commented not required when quicksort uses it as quicksort handles it
//    if(arr.length <= 1){

//
//        return 0;
//    }
    int pivot = arr[high];
    int i = low;
    int j = high-1;
    int temp;
    while (i<j){
        if (arr[i]<=pivot){
            i++;
        }
        else {
             temp= arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
    if (arr[i]<=pivot){
        i++;

    }
    temp = arr[i];
    arr[i] = pivot;
    arr[high]= temp;




    return i;
    }

}

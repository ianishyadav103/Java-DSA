import java.util.Arrays;

//Merge Sort: TC: O(n log n), SC: O(n), Stable(does it maintain original order when similar keys): Yes


public class J10_AdvancedSortMerge {
    static void main() {
    //Function For Combining Two Sorted Arrays--------------------------------------
    int[] ar1 = {1,2,2,3,4,33,33,44,55};
    int[] ar2 = {0,3,3,3,4,16,66};
    System.out.println(Arrays.toString(combineSortedArrays(ar1, ar2)));

    //Iterative Merge Sort---------------------------------------------------------------------------
    int[] arr = {6,4,3,2,1};
    DivideUntilSingleIterativeWay(arr);
    System.out.println(Arrays.toString(arr));

    //Tried to implement merge sort using recursion but this inefficient as created new sub arrays------
    int[] arrz1 = {6,5,1,2,4,3,0,33,4,22,1};
    System.out.println(Arrays.toString(practiceRecursiveDivideUnitilSingleMergeSort(arrz1)));

    //Standard Merge sort using recursion with a standard merge function--------------------------
            //Convention: mid is part of left array and high included
        int[] arrz2 = {6,5,4,2,4,3,4,33,4,22,1,2,32,1};
    recursiveMergeSort(arrz2,0,arrz2.length-1);

        System.out.println(Arrays.toString(arrz2));


    }

    //Combined sorted arrays in iterative way: TC: 0(m+n), SC: 0(m+n)
            //SC:  can become 0(1) if in-place: one array has enough space but  complex to implement
    static int[] combineSortedArrays(int[] ar1, int[] ar2){
        int[] result = new int[ar1.length + ar2.length];
        int i=0,j=0,k=0;

       while (i<ar1.length && j<ar2.length) {

            if (ar1[i]<ar2[j]){
                result[k] = ar1[i];
                k++;
                i++;

            }
            else if (ar1[i]>ar2[j]){
                result[k] = ar2[j];
                k++;
                j++;
            }
            else {
                result[k++] = ar1[i++];
                result[k] = ar2[j++];
                k++;
            }

        }
        while (i<ar1.length){
            result[k++] = ar1[i++];
        }
        while (j<ar2.length){
            result[k++] = ar2[j++];

        }

        return result;

    }

    static int[] combineSortedArraysFromRange(int[] arr, int low,int mid,int high){
        int[] ar1 = new int[mid-low];
        int[] ar2 = new int[high-mid];



        for (int i = low; i < mid; i++) {
            ar1[i-low] = arr[i];

        }

        for (int i = mid; i < high; i++) {
            ar2[i-mid] = arr[i];


        }



        return combineSortedArrays(ar1,ar2);


    }

    static void DivideUntilSingleIterativeWay(int[] arr){


        for (int i = 1; i < arr.length; i=i*2) {

            for (int j = 0; j < arr.length; j=j+2*i) {

                int high =  j+2*i;
                int mid = j+i;
                if (high> arr.length){
                    high = arr.length;
                }
                if (mid> arr.length){
                    mid = arr.length;
                }




               int[] result =combineSortedArraysFromRange(arr, j, mid, high);
               int x = 0;
                for (int k = j; k < high; k++) {
                    arr[k] = result[x];

                    x++;
                }






            }
        }
    }


    static int[] practiceRecursiveDivideUnitilSingleMergeSort(int[] arr){
       if (arr.length ==1){

           return arr;
       }
        int mid = arr.length/2;

       int[] leftArr = new int[mid];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];
        }

        leftArr = practiceRecursiveDivideUnitilSingleMergeSort(leftArr);



       int[] rightArr = new int[arr.length - mid];
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid+i];
        }


        rightArr = practiceRecursiveDivideUnitilSingleMergeSort(rightArr);


        return combineSortedArrays(leftArr,rightArr);

    }

    static void recursiveMergeSort(int[] arr,int low, int high){
        if (low < high) {
        int mid = (low + high) / 2;
        recursiveMergeSort(arr,low,mid);
        recursiveMergeSort(arr,mid+1,high);



        merge(arr,low,mid,high); }
    }

    static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid+1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }


}

import java.lang.reflect.Array;
import java.util.Arrays;

public class J2_Array {
    static void main() {
        int[] arr= new int[50]; //initialized to zero
        int n = 6; //filled size

        //size of arr
        System.out.println(arr.length); //O(1) as property

        //tranverse with filling
        for (int i = 0; i < n; i++) {
            arr[i] = i+11;
        }

        //printing
        System.out.println(Arrays.toString(arr)); //print full array
        printarr(arr,n);


        n = deleteAtIndex(arr,0,n);
        printarr(arr,n);
        n = interstAtIndex(arr,4,n,22);
        printarr(arr,n);

    //Binary Search
        int[] sorted_arr =  {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(sorted_arr,2,7));
        System.out.println(binarySearch(sorted_arr,7,7));
        System.out.println(binarySearch(sorted_arr,32,7));


    //2D Array: jagged Array: don't specify column size hence each row contain null
        int[][] arr2d = new int[3][];
        System.out.println(Arrays.toString(arr2d));
        System.out.println(arr2d.length);

        //can give custom size to each row hence memory efficient
        arr2d[0] = new int[3];
        arr2d[1] = new int[2];
        System.out.println(Arrays.toString(arr2d[0]));

    }

    //insert at index
    static int interstAtIndex(int[] arr, int ind, int filled_size,int val){
        for (int i = filled_size; i > ind; i--) {
            arr[i] = arr[i-1];
        }
        arr[ind]=val;
        return ++filled_size;
    }

    //delete at index
    static int deleteAtIndex(int[] arr,int ind, int filled_size){
        filled_size--;
        for (int i = ind; i < filled_size; i++) {
            arr[i] = arr[i+1];
        }
        arr[filled_size] = 0; //not necessary in production code
        return filled_size;
    }
    static void printarr(int[] arr, int filled_size){
        for (int i = 0; i < filled_size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static int binarySearch(int[] arr,int key,int filled_size){
        int low =0;
        int high = filled_size-1;
        int mid;
        while (low<=high){
            mid = low + (high-low)/2;
            if(arr[mid] == key){
                return mid;
            } else if (arr[mid]>key) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }
        return -1;
    }


}

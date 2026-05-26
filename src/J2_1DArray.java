import java.util.Arrays;

public class J2_1DArray {
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


}

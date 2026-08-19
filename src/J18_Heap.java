import java.util.Arrays;

class HeapDS{
   int capacity;
   int size;



    public HeapDS(int capacity) {
        this.capacity = capacity;
        this.heap =  new int[capacity];
    }

    int[] heap;


    void insertHeaplifyUp(int val){
        //add at end then compare with parent and swap repeatedly until required
        if (size < capacity){
            int ind = size++;
            heap[ind] = val;
            int parent_ind = (ind - 1) / 2;
            while (ind>0 && heap[parent_ind]<heap[ind] ){
                int temp =   heap[ind];
                heap[ind] = heap[parent_ind];
                heap[parent_ind] = temp;
                ind = parent_ind;
                parent_ind = (ind - 1) / 2;

            }

            System.out.println("Insertion Success");
        }
        else {
            System.out.println("Tree full, Insertion Failed");
        }
    }
    void deleteHeaplifyDown(){
        int ind = 0;
        System.out.println("Largest: " + heap[ind]);
        //replace last element with root
        heap[ind] = heap[--size];

        //heaplifyDown
        while (ind<size){
            int leftChildInd = ind * 2 + 1;

            int rightChildInd = ind * 2 + 2;
            if (leftChildInd >=size){
                break;
            }
            int largechild = leftChildInd;
            if (rightChildInd<size && heap[leftChildInd]<heap[rightChildInd]){
                largechild = rightChildInd;
            }
            if (heap[largechild]>heap[ind]){
                int temp = heap[largechild];
                heap[largechild] = heap[ind];
                heap[ind] = temp;
                ind = largechild;
            }
            else{
                break;
            }
        }
    }
    void deeletSpecified(int key){

    }


    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    static void buildHeap(int[] arr){
        int size = arr.length;
        int indz = size / 2 - 1;
        while (indz >= 0) {
            int ind = indz;
            while (ind<size){
                int leftChildInd = ind * 2 + 1;

                int rightChildInd = ind * 2 + 2;
                if (leftChildInd >=size){
                    break;
                }
                int largechild = leftChildInd;
                if (rightChildInd<size && arr[leftChildInd]<arr[rightChildInd]){
                    largechild = rightChildInd;
                }
                if (arr[largechild]>arr[ind]){
                    int temp = arr[largechild];
                    arr[largechild] = arr[ind];
                    arr[ind] = temp;
                    ind = largechild;
                }
                else{
                    break;
                }
            }
            indz--;
        }


    }
    void HeapSort(){
        int sizex  = size;
      while (sizex>0){
          int ind = 0;

          System.out.println("Largest: " + heap[ind]);

          int temp  = heap[ind];
          heap[ind] = heap[--sizex];
          heap[sizex] = temp;

          //heaplifyDown
          while (ind<sizex){
              int leftChildInd = ind * 2 + 1;

              int rightChildInd = ind * 2 + 2;
              if (leftChildInd >=sizex){
                  break;
              }
              int largechild = leftChildInd;
              if (rightChildInd<sizex && heap[leftChildInd]<heap[rightChildInd]){
                  largechild = rightChildInd;
              }
              if (heap[largechild]>heap[ind]){
                  int tempx = heap[largechild];
                  heap[largechild] = heap[ind];
                  heap[ind] = tempx;
                  ind = largechild;
              }
              else{
                  break;
              }

          }
      }
    }

}


public class J18_Heap {
    static void main() {
// Heap
// A Heap is a Complete Binary Tree (as usually stored in array)+ Heap Property

// Complete Binary Tree:
// Every level is completely filled except possibly the last.
// The last level is filled from LEFT to RIGHT.

// Max Heap:
// Parent >= its children
// Root contains the MAXIMUM element.

// Min Heap:
// Parent <= its children
// Root contains the MINIMUM element.

//Uses: Priority Queue, Min,Max

/*
arr[(i-1)/2]	Returns the parent node
arr[(2*i)+1]	Returns the left child node
arr[(2*i)+2]	Returns the right child node
*/


        HeapDS h1 = new HeapDS(50);

        h1.insertHeaplifyUp(10);
        h1.insertHeaplifyUp(30);
        h1.insertHeaplifyUp(40);
        h1.insertHeaplifyUp(25);
        h1.insertHeaplifyUp(5);
        h1.insertHeaplifyUp(20);
        h1.insertHeaplifyUp(15);

        h1.printHeap();
        h1.deleteHeaplifyDown();
        h1.deleteHeaplifyDown();
        h1.deleteHeaplifyDown();
        h1.printHeap();

        h1.HeapSort();
        h1.printHeap();

        int[] arr = {10, 30, 20, 5, 40, 15};
        HeapDS.buildHeap(arr);
        System.out.println(Arrays.toString(arr));



    }
}

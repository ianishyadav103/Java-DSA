class MyStackArr{
    //Stack Using Array
    int top =  -1;
    int[] arr = new int[50];

    int push(int value){
        if(top==arr.length-1){
            System.out.println("Stack full can't insert");
            return top;
        }
        arr[++top] = value;
        return top;
    }
    int pop(){
        if (top==-1){
            System.out.println("Can't pop: stack  empty,returning -1(not a value)");
            return top;
        }

        return arr[top--];
    }
    void peek(){
        if (top==-1){
            System.out.println("Can't peek: stack empty");
            return;
        }
        System.out.println(arr[top]);


    }
}

class MyStackLL{
    SingleLL top;
    SingleLL push(int val){
        SingleLL sl = new SingleLL(val);
        if(top==null){ //this block can ab avoided as same thing happening below with just one extra step.
            top = sl;
            return top;
        }
        sl.next = top;
        top = sl;
        return top;
    }
    int pop(){
        if (top==null){
            System.out.println("Stack LL empty, can't pop hence returning -1(not a value)");
            return -1;
        }
        int data = top.val;
        top = top.next;
        return data;
    }
}

public class J7_Stack { //LIFO
    static void main() {
        MyStackArr st1 = new MyStackArr();
        st1.pop();
        st1.push(11);
        st1.push(12);
        st1.push(13);
        st1.peek();
        st1.pop();
        st1.peek();


        MyStackLL stl1 = new MyStackLL();
        stl1.push(11);
        stl1.push(12);
        stl1.pop();


    }
}

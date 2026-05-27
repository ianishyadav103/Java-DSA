//SINGLE
class SingleLL{
    int val;
    SingleLL next;

    SingleLL(int val){
        this.val = val;
    }
    }

    class  DoubleLL{
    int val;
    DoubleLL prev;
    DoubleLL next;
    DoubleLL(int val){
        this.val = val;
    }



    }
    //dont do this, just experimenting OOPS
class SingleCircular extends SingleLL{  //next of last points first
    SingleCircular(int val){
        super(val);
    }
}

class DoubleCircular extends DoubleLL{ //prev of first point to last and next to last to first
    DoubleCircular(int val){
        super(val);
    }
}

public class J6_LinkedList {


    static void main(String[] args) {

        //Single LL use---------------------------------------------------
        SingleLL start = null;
        start = insertAtEnd(start,11);
        start = insertAtEnd(start,13);
        start = insertAtEnd(start,14);
        start = insertAtEnd(start,15);
        start = addBeforeItem(13,start,12);
        start = addBeforeItem(99,start,12);
        deleteAfterItem(99,start);
        deleteAfterItem(14,start);
        traverseForward(start);

        //Duble LL use-----------------------------------------------------
        DoubleLL front = null;
        DoubleLL last = null;
        //operations: insertBefore
        //insert at last
        //reverse traverse

        //Single Circular LL use-----------------------------------------------------
        SingleCircular startSCLL = null;
        //operations: insert at begin
        //delete last
        //circular traversal
        //search


        //Duble Circular LL use-----------------------------------------------------
        DoubleCircular startDCLL = null;
        //operations:

    }
    //Single LL functions---------------------------------------------------
    static SingleLL addBeforeItem(int key,SingleLL start,int dat){
        SingleLL temp = start;
        if(temp==null){
            System.out.println("No matching node found hence insert cancelled");
            return temp;
        }
        SingleLL newnode = new SingleLL(dat);

        if (temp.val ==key) {
            newnode.next = temp;
            return newnode;

        } else {
            while (temp.next!=null){
                if(temp.next.val == key){
                    newnode.next = temp.next;
                    temp.next = newnode;
                    System.out.println("Added");

                    return start;
                }
                temp = temp.next;
            }
            System.out.println("No matching found");
            return start;
        }
    }

    //insertAtEnd
    static SingleLL insertAtEnd(SingleLL start,int dat){
        SingleLL temp = start;
        SingleLL newnode = new SingleLL(dat);

        if(temp==null){
            return newnode;

        }
        else {
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newnode;

        }
        return start;




    }

    //traverse forward
    static void traverseForward(SingleLL temp){
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    static void deleteAfterItem(int key,SingleLL start){
        SingleLL temp = start;
        if(temp==null){
        System.out.println(("Can't delete as empty"));
        return;

        }
        else {
            while (temp!=null){
                if(temp.val == key){
                    if(temp.next!=null){
                        temp.next = temp.next.next;
                        System.out.println("Deleted");
                        return;
                    }
                }
                temp = temp.next;
            }
        }
        System.out.println("Not found");

    }

    //Double LL functions---------------------------------------------------
    //Single Circular LL functions---------------------------------------------------
    //Double Circular LL functions---------------------------------------------------


}

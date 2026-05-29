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
class SingleCircular {  //next of last points first
    int val;
    SingleCircular next;
    SingleCircular(int val){
        this.val = val;
    }
}


class CircularLL {
    SingleCircular head;
    SingleCircular tail;
}

class DoubleCircular{ //prev of first point to last and next to last to first
    int val;
    DoubleLL prev;
    DoubleLL next;
    DoubleCircular(int val){
        this.val = val;
    }
}

public class J6_LinkedList {


    static void main() {

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
        DoubleLL last = null; //optional: based on requirement


        //Single Circular LL use-----------------------------------------------------
        CircularLL cll = new CircularLL();
        insertAtBegin(12,cll);
        insertAtBegin(14,cll);
        insertAtBegin(13,cll);
        deleteLast(cll);
        searchSingleCircular(cll,12);



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
    static DoubleLL insertBefore(int dat,int key,DoubleLL start){
        DoubleLL temp = start;
        if(start != null){
            DoubleLL newnode = new DoubleLL(11);
            if(start.val==key){
                newnode.next = start;
                start.prev = newnode;
                start = newnode;
                return start;
            }
            while (temp.next!=null){
                if(temp.next.val==key){
                    newnode.next = temp.next;
                    newnode.prev = temp;
                    temp.next.prev = newnode;
                    temp.next = newnode;

                    return start;
                }
                temp = temp.next;
            }

        }
        System.out.println("Key not found");
        return start;
    }

    //reverse traverse
    void doubleLLReverseTraverse(DoubleLL last){
        if (last==null){
            System.out.println("LL Empty");
            return;
        }
        while (last!=null){
            System.out.println(last.val);
            last = last.prev;
        }
    }

    //Single Circular LL functions---------------------------------------------------

    static void insertAtBegin(int dat,CircularLL cll) {
        SingleCircular newnode = new SingleCircular(dat);
        if (cll.head!= null) {
            newnode.next = cll.head;
            cll.tail.next = newnode;
            cll.head = newnode;

        }
        else {
            cll.head = newnode;
            newnode.next = newnode;
            cll.tail = newnode;
        }


    }
    static void deleteLast(CircularLL cll){
        if (cll.head==null){
            System.out.println("Can;t delete as empty");

        }
        else {
            SingleCircular temp = cll.head;
            SingleCircular prev = null;

            while (temp != cll.tail) {
                prev = temp;
                temp = temp.next;

            }
            if (prev == null) {
                cll.head = null;
                cll.tail = null;
                System.out.println("Deleted");
            }
            else {
                prev.next = cll.head;
                cll.tail = prev;

            }
        }
    }

    static void searchSingleCircular(CircularLL cll,int key){
        if(cll.head != null){
            if(cll.tail.val == key){
                System.out.println("Key found");
                return;
            }
            SingleCircular temp = cll.head;
            while (temp!=cll.tail){
                if (temp.val == key){
                    System.out.println("Key found");
                    return;
                }
                temp = temp.next;
            }

        }

            System.out.println("Key not found");




    }




}

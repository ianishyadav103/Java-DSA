class QueueArr{
    //LL implementation: single LL used.
    int front = -1;
    int rear = -1;
    int[] arr = new int[50];


    //enqueue
    int enqueue(int dat){
    if(rear==arr.length-1){
        System.out.println("Can't insert, queue full;");
        return -1;
        } else if (front==-1) {
        front++;
        arr[++rear] = dat;
        return rear;
    }
        arr[++rear] = dat;
        return rear;

    }
    //deque
    int dequeue(){
        if(rear==-1 || front>rear){
            System.out.println("Can't delete, queue empty;");
            return -1;
        }
        return arr[front++];

    }


}
//Important: Subtypes of Dequeue exist: Input Restricted and Output Restricted.

class DeQueueArr{
    //LL: Use double linked list so deletion from last doest require to find last second element

    int front = -1;
    int rear = -1;
    int[] arr = new int[50];

    int insertAtFront(int val){
        if (front==-1){
            front = 0;
            rear = 0;
            arr[front]= val;
            return front;}
        if(front==0){
            System.out.println("Can't insert at front as no space");
            return front;}

        front--;
        arr[front]= val;
        return front;
        }


        void deleteAtFront(){
        if (front==-1){

            System.out.println("Already empty, can't insert at front");
            return;
        }
        if(front==rear){
            System.out.println("Deleted: "+ arr[front]);
           front=-1;
           rear=-1;
            return;
            }
            System.out.println("Deleted: "+ arr[front++]);


        }

    int insertAtRear(int val){
        if(rear== arr.length-1){
            System.out.println("Can't insert as no space on right");
            return rear;}
        if (rear==-1){
            front = 0;
            rear = 0;
            arr[rear]= val;
            return rear;}
        rear++;
        arr[rear]= val;
        return rear;
    }

    void deleteAtRear(){
        if (rear==-1){
            System.out.println("Already empty, can't delete at rear");
            return;
        }
        if(front==rear){
            System.out.println("Deleted: "+ arr[rear]);
            front=-1;
            rear=-1;
            return;
        }
        System.out.println("Deleted: "+ arr[rear--]);


    }
}
class CircularQueueArr{
    int front = -1;
    int rear = -1;
    int[] arr = new int[50];
    int insert(int val){
        if(front==-1){
            front=0;
            rear=0;
            arr[rear] = val;

            return rear;
        }
        if (front==((rear+1)%arr.length)){
            System.out.println("Full, can't insert");
            return rear;
        }
        rear = (rear+1)%arr.length;
        arr[rear] = val;
        return rear;
    }
    Integer delete(){
        if(front==-1){
            System.out.println("empty, can't delete");
            return null;
        }
        if (front==rear){
            int dat=arr[front];
            front=-1;
            rear = -1;
            return dat;
        }
        int dat=arr[front];
        front= (front+1)%arr.length;
        return  dat;

    }
}

class PriorityQueueArr{
    //priority queue: element accessed based on priority using heap
}

class Queuell{
    SingleLL head = null;
    SingleLL tail = null;
    SingleLL insert(int val){
        SingleLL newnode = new SingleLL(val);
        if(head==null){
            head=newnode;
            tail=newnode;
            return newnode;
        }
        tail.next = newnode;
        tail = newnode;
        return newnode;
    }
    SingleLL delete(){
        if(head==null){
            System.out.println("Can't delete: queue empty");
            return null;
        }
        if (head==tail){
            SingleLL x = head;
            head=null;
            tail = null;
            return x;

        }
        SingleLL x = head;
        head = head.next;
        return x;
    }

}


public class J8_Queue {
    static void main() {

    }
}

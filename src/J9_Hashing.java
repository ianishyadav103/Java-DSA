
class SingleLLkey extends SingleLL{
    int key;
    SingleLLkey next;

    SingleLLkey(int key,int val) {
        super(val);
        this.key = key;
    }
}

//HashMap Implementation:each bucket in a linked list
class MyHashMapChaining{
    int size = 0;

    SingleLLkey[] buckets = new SingleLLkey[10];
    void insert(int key,int val){
        int ind = J9_Hashing.hash(key,buckets.length);

        SingleLLkey temp = buckets[ind];
        if(temp==null){
            buckets[ind] = new SingleLLkey(key,val);
            size++;
        }
        else {


                SingleLLkey tempnext = temp;
                temp = null;
                while (tempnext!=null){

                    if (tempnext.key == key){
                        tempnext.val = val;
                        System.out.println("Matching key found, value updated");
                        return;
                    }
                    temp = tempnext;
                    tempnext = tempnext.next;
                }
            temp.next = new SingleLLkey(key,val);
            size++;

            }
        }


    void get(int key){

            int ind = J9_Hashing.hash(key,buckets.length);
            SingleLLkey temp = buckets[ind];

            while (temp!=null){
                if (temp.key==key){
                    System.out.println("Value: " + temp.val);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Key not found");

    }
    void delete(int key){

            int ind = J9_Hashing.hash(key,buckets.length);
            SingleLLkey temp = buckets[ind];
            if (temp==null){
                System.out.println("Key not found");
                return;
            }
            if (temp.key==key){
                buckets[ind] = temp.next;
                System.out.println("Deleted");
                size--;
                return;
            }
            while (temp.next!=null){
                if (temp.next.key==key){
                    temp.next = temp.next.next;
                    System.out.println("Deleted");
                    size--;
                    return;

                }
                temp = temp.next;
            }
            System.out.println("Key not found");

    }
}

public class J9_Hashing {
    static void main() {
        //->Array of buckets for first data at that index
        //->hash function: find index for string data by processing key
        /*->collision handling mechanism:
             -->chaining: Linked List: for each bucket
             -->open addressing: Linear Probing: use next available bucket*/
        /*Load Factor: Measures how full hash table is: stored elements/total buckets but this doest tell if individual bucket has many elements hence to avoid this in java first rehash occurs till size becomes 64 and after which if any bucket has more than 8 elements, that bucket converted to Red-Black Tree (a self-balancing binary search tree).*/
        //Same Key: Update Value;
        //Same bucket: collision
        //Rehashing: increase bucket count: as new size, all key must be restored
        //Bucket: for storing data/first data
        /*bucket initial size: (total element expected/0.75)+1=>then closes to power2. e.g. -> 50->67.6=128(64 is smaller hence 64*2)*/


        //HashSet: Only store Keys(uses hashmap but value is dummy i.e. no need to have this filed in node). if same key then ignore
        //HashMap: Key value Pair







    }
    //Hash Function
    static int hash(int key,int bucketSize){
        return key%bucketSize;
    }

}

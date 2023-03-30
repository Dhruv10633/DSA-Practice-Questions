package Topics.T12_HashMap_HashSet;
import java.util.*;

public class HashMap_imple {
    //ThreshHold fac: no of elements in each bucket (or linked list in array)
    //Load fac: Total size of arr/No of elements present

    //LF < THF

    public static void main(String[] args) {
        hMap <String,Integer> hmap=new hMap<>();
        //Insertion
        hmap.put("Ram",89);
        hmap.put("Raj",89);
        hmap.put("Dhruv", 91);
        hmap.put("Ramesh",34);
        // hmap.put(null,34);  //works fine in hmap

        System.out.println(hmap);

        //Deletion (returns val correspond to key deleted)
        hmap.remove("Ram");

        //accessing
        hmap.get("Ram");

        //check if key present (Bool)
        System.out.println(hmap.containsKey("Ramu"));
        System.out.println(hmap);
        
    }

    
}

//Genric HashMap
class hMap <K,V>{
    class Node{
        K key;
        V val;
        Node next;

        Node(){}
        Node(K key ,V val){
            this.key=key;
            this.val=val;
        }
    }

    private ArrayList<Node> bucket;
    int size;
    
    hMap(){
        //searches for this type of constructor 
        //by default hMap of size 4
        this(4);
    }
    hMap(int x){
        bucket=new ArrayList<>();

        size=x;
        for(int i=0;i<x;i++){
            bucket.add(null);
        }
    }

    public int hashFunc(K key){
        //always give a unique hash number for each element
        //Hash Function
        int bt=key.hashCode() % this.bucket.size();

        //in case of -ve hashCode
        if(bt<0){
            bt+=bucket.size();
        }
        return bt;
    }

    //Put
    public void put(K key,V value){
        //generate hashVal of key 
        int bt=hashFunc(key);

        //getting address if any nodes there at that pos
        Node temp=bucket.get(bt);

        while(temp!=null){

            //if key exists we change the val and return
            if(temp.key.equals(key)){
                temp.val=value;
                return;
            }
            temp=temp.next;
        }

        //else enter at beginning/end
        temp=new Node(key,value);
        temp.next=bucket.get(bt);

        bucket.set(bt,temp);

        this.size++;
        //Load Factor : toatal elelments present / size of bucket availlable
        double LF =(1.0 * this.size)/this.bucket.size();
        //max 2 elements in 1 index of arr
        //Threshhold factor
        double THF=2.0;

        if(LF>THF){
            rehashing();
        }

    }
    public void rehashing(){
        ArrayList<Node> newBucket=new ArrayList<>();
        

        //this step is imp as the below put method in the loop works only in the bucket arraylist
        ArrayList<Node> temp=this.bucket;
        this.bucket=newBucket;

        for(Node n: temp){
            while(n!=null){
                put(n.key,n.val);
                n=n.next;
            }
        }
    }

    //Get
    public V get(K key){
        int bt=hashFunc(key);

        //getting address if any nodes there at that pos
        Node temp=bucket.get(bt);

        while(temp!=null){

            //if key exists we change the val and return
            //
            if(temp.key.equals(key)){
                return temp.val;
            }
            temp=temp.next;
        }
        return null;
    }

    public V remove(K key){
        int bt=hashFunc(key);

        //getting address if any nodes there at that pos
        Node prev=null;
        Node temp=bucket.get(bt);

        while(temp!=null){

            if(temp.key.equals(key)){
                break;
            }
            prev=temp;
            temp=temp.next;
        }

        if(temp==null) return null;

        else if(prev==null){
            bucket.set(bt,temp.next);
            temp.next=null;
            return temp.val;
        }

        else{
            prev.next=temp.next;
            temp.next=null;

            return temp.val;
        }
    }

    public boolean containsKey(K key){
        int bt=hashFunc(key);
        
        Node temp=bucket.get(bt);

        while(temp!=null){
            if(temp.val==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    //overriding default method
    @Override
    public String toString(){
        String ans="{ ";

        for(Node temp: this.bucket){
            while(temp!=null){
                ans+=temp.key+"="+temp.val+", ";
                temp=temp.next;
            }
        }
        ans+=" }";
        return ans;
    }

}

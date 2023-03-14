//https://leetcode.com/problems/lru-cache/submissions/879090546/
package Linked_Lists;
import java.util.*;

class LRUCache {
    Map<Integer,Integer> map;
    int size;
    public LRUCache(int capacity) {
        size=capacity;
        map=new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int val=map.get(key);
            map.remove(key);
            map.put(key,val);

            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }
        else if(map.size()<size){
            map.put(key,value);
        }
        else{
            int k=0;
            for(int x:map.keySet()){
                k=x;
                break;
            }
            map.remove(k);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

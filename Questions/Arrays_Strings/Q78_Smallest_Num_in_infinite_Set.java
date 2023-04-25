// https://leetcode.com/problems/smallest-number-in-infinite-set/description/
package Arrays_Strings;
import java.util.*;

/*
Since we can't store the infinite num, but we can for sure add the removed nums to the set,
which keeps a track of all the nums popped
*/

class SmallestInfiniteSet {
    Set<Integer> removed;
    public SmallestInfiniteSet() {
        removed = new HashSet<>();
    }
    
    public int popSmallest() {
        int curr=1;
        while(removed.contains(curr)){
            curr++;
        }
        removed.add(curr);
        return curr;
    }
    
    public void addBack(int num) {
        if(removed.contains(num))removed.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
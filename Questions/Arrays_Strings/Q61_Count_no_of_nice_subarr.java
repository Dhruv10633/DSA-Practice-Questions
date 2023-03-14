//https://leetcode.com/problems/count-number-of-nice-subarrays/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int odd=0;
        Map <Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                odd++;
            }      
            if(map.containsKey(odd-k)){
                count+=map.get(odd-k);
            }

            map.put(odd, map.getOrDefault(odd,0)+1);  
        }
        return count;
        
    }
}

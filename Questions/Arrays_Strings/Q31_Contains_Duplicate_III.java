// https://leetcode.com/problems/contains-duplicate-iii/
package Arrays_Strings;
import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int idf, int vdf) {
        TreeSet<Integer> set=new TreeSet<>();

        int s=0;
        for(int i=0;i<nums.length;i++){
            //Integer can contain null in case no val present

            //We take the ceil and floor value cause we are given the abs condition
            //so we need to check the just lower and higher value 
            Integer x=set.ceiling(nums[i]);

            if(x!=null && x-nums[i] <= vdf){
                return true;
            }

            x=set.floor(nums[i]);

            if(x!=null && nums[i] - x <= vdf){
                return true;
            }

            set.add(nums[i]);

            if(set.size()>idf){
                set.remove(nums[s]);
                s++;
            }
            
        }

        return false;
    }
}


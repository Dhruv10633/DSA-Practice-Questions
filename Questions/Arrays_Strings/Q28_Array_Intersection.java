//https://leetcode.com/problems/intersection-of-two-arrays/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans=new ArrayList<>();

        HashMap<Integer,Integer> mp1=new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            mp1.put(nums1[i], mp1.getOrDefault(nums1[i],0)+1);
        }

        for(int i=0;i<nums2.length;i++){
            if(mp1.containsKey(nums2[i]) && mp1.get(nums2[i])>0 ){
                
                mp1.put( nums2[i], 0);
                ans.add(nums2[i]);
                
            }
        }
        int[] fans=new int[ans.size()];
        
        for(int i=0;i<fans.length;i++){   
            fans[i]=ans.get(i);
        }
        
        return fans;
    }
}

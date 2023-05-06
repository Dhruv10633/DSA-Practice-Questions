// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0, mod = 1000000007;

        //for storing power
        int[] pow2 = new int[nums.length];
        pow2[0]=1;
        for(int i=1 ;i<pow2.length ;i++){
            pow2[i] = (pow2[i-1]*2) % mod;
        }

        int l=0, h=nums.length-1;
        while(l<=h){
            if(nums[l]+nums[h] <= target){
                count += pow2[h-l];   //all the valid subsequences with nums[l] as the fixed min and (h-l) as the total number of maximums with which it can create subseq
                count %= mod;
                l++;
            }
            else{
                h--;
            }
        }

        return count;
    }
}

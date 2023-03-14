//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
package DP;
import java.util.*;

class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans=1;

        for(int i = 0 ; i<arr.length ; i++){
            //default length=1
            int len = 1;
            //if the prev element of the AP exists then we add the size of subarr till that ele to the curr
            len += map.getOrDefault(arr[i]-diff, 0);

            map.put(arr[i], len);

            ans = Math.max(ans, len);
        }
        
        return ans;
    }
}

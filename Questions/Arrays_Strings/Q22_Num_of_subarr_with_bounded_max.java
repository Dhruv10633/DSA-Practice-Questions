//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
package Arrays_Strings;

public class Q22_Num_of_subarr_with_bounded_max{
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int ans=0;
        
        int si=0,ei=0,prev=0;

        while(ei<arr.length){
            //if in range
            if(arr[ei]>=left && arr[ei]<=right){
                prev=ei-si+1;
                ans+=prev;
            }
            //if we find less
            //we just add the prev arr not the less element subarr 
            //eg ([5] || [5,14] if left=32)
            else if(arr[ei]<left){
                ans+=prev;
            }
            //if we find greater 
            else if(arr[ei]>right){
                prev=0;
                si=ei+1;
            }
            ei++;
        }

        return ans;
    }
}
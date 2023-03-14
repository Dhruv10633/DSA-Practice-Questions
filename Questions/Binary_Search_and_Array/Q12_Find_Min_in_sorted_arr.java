//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
package Binary_Search_and_Array;

class Solution {
    public int findMin(int[] arr) {
        int ans=5001;
        int l=0,h=arr.length-1;
        
        while(l<=h){
            int mid=(l+h)/2;
            //if mid val >= value at h
            //also check the value at l and h
            if(arr[mid]>=arr[h] && arr[l]>=arr[h]){
                l=mid+1;
            }
            
            else{
                h=mid-1;
            }
            
            ans=Math.min(ans,arr[mid]);
        }
        return ans;
    }
}

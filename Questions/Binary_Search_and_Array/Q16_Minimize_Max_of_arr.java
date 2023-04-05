// https://leetcode.com/problems/minimize-maximum-of-array/description/
package Binary_Search_and_Array;

class Solution {
    public int minimizeArrayValue(int[] arr) {
        int l=0, h=maxEle(arr), ans=-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(isPoss(mid, arr)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }


    private boolean isPoss(int mid, int[] arr){
        long sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            /*
            As for all the values on the left side of curr 'i' must be <= 'mid'
            */
            if(sum > (long)(i+1)*(mid)) return false;
        }
        return true;
    }


    private int maxEle(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

// https://leetcode.com/problems/maximum-product-subarray/
package Arrays_Strings;

class Solution {
    public int maxProduct(int[] nums) {
        int fwd=1, bwd=1;
        int maxProd = Integer.MIN_VALUE;

        for(int i=0, j=nums.length-1 ; i<nums.length && j>=0 ; i++,j--){
            fwd *= nums[i];
            bwd *= nums[j];
            maxProd = Math.max(maxProd, Math.max(fwd, bwd)); 

            if(fwd == 0) fwd=1;
            if(bwd == 0) bwd=1;  
        }         
        return maxProd;
    }
}

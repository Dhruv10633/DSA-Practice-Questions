package Arrays_Strings;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) { 
        //Dont use HashMap as the prod u need to maintain might 
        //cross the long limit too then  
        int s=0 , count=0;
        long prod = 1;

        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            while(s<i && prod>=k){
                prod /= nums[s];
                s++;
            }
            if(prod<k)count+= i-s+1;
        }

        return count;
    }
}

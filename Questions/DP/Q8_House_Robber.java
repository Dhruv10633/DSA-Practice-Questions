//https://leetcode.com/problems/house-robber/description/
package Questions.DP;

//TOP DOWN
class Solution1 {
    public int rob(int[] nums) {
        //dp of size = number of houses
        int dp[]=new int[nums.length];

        //could cause probs with 0
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }

        return maxRob(nums, 0, dp);
    }
    
    //Memoization
    private int maxRob(int[] nums, int i, int[]dp){
        if(i>=nums.length){
            return 0;
        }

        if(dp[i]!=-1)
            return dp[i];

        //if he robs then he skips next;
        int rob = nums[i] + maxRob(nums, i+2, dp);
        //he moves to next house
        int notRob = maxRob(nums, i+1, dp);
        //storing the ans at that address if not found above
        dp[i] = Math.max(rob, notRob);

        return dp[i];
    }

    //Tabulation
    public int maxRob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        nums[1]=Math.max(nums[0],nums[1]);

        for(int i=2 ; i<n ;i++){
            nums[i] = Math.max(nums[i]+nums[i-2], nums[i-1]); 
        }
        return nums[n-1];  
    }
}


//Space Optimised
class Solution2 {

    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int a=nums[0], b=Math.max(nums[0],nums[1]);

        //Similar to Fibonacci
        for(int i=2 ; i<n ;i++){
            int temp = Math.max(a+nums[i], b);
            a=b;
            b=temp;
        }
        return b;  
    }
}

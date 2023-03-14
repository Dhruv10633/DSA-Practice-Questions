//https://leetcode.com/problems/gas-station/description/
package Arrays_Strings;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=-1;
        int pos_sum=0, sum=0;

        for(int i=0; i<cost.length ;i++){
            int temp=gas[i]-cost[i];

            sum+= temp;

            pos_sum+=temp;

            //we have to find the last +ve subarr sum (of gas[i]-cost[i])
            //and also find the 1st most start point of the arr

            //if pos_sum<0 i.e. not enough gas
            if(pos_sum < 0){
                start=-1;
                pos_sum=0;
            }
            else{
                if(start==-1) start=i;  
            }

        }
        //if the sum of diff < 0 then no solution exists (not enough gas)
        if(sum < 0) return -1;
        return start;
    }
}

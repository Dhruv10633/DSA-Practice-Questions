//https://leetcode.com/problems/minimum-size-subarray-sum/
package Arrays_Strings;
// import java.util.*;

public class Q15_Min_Subarr_sum{

    public static int minSubArrayLen(int target, int[] arr) {
        int i=0,start=0;
        int sum=0;
        int length=Integer.MAX_VALUE;

        while(i<arr.length){
            sum+=arr[i];
            
            //we keep reducing sum till we get sum<targ so as to get the min length
            while(start<=i && sum>=target){
                length=Math.min(length,i-start+1);
                sum-=arr[start];
                start++;
            }
            i++;
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }    

}
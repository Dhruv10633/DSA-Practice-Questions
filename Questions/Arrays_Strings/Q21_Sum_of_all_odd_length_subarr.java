// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/
package Arrays_Strings;

public class Q21_Sum_of_all_odd_length_subarr {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int [] presum=new int[n+1];

        presum[0]=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            presum[i+1]=sum;
        }

        int fin_sum=presum[n];

        for(int i=3;i<=n;i+=2){

            int j=0;
            while(j+i < n+1){
                fin_sum += presum[j+i]-presum[j];
                j++;
            }
        }
        return fin_sum;    
    }
}

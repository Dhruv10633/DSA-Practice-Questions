// https://leetcode.com/problems/subarray-sums-divisible-by-k/
package Arrays_Strings;
import java.util.*;

class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Long,Integer> map=new HashMap<>();
        long sum=0;
        int count=0;
        map.put(0l,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            //we need to store the rem ,not the entire sum
            //in case of -ve sum we add k 
            long rem = sum % k >=0 ? sum % k : sum % k+k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}

class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        int remArr[] = new int[k];
        long sum=0;
        int count=0;
        remArr[0]=1;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            //we need to store the rem ,not the entire sum
            //in case of -ve sum we add k 
            int rem = sum % k >=0 ? (int)(sum % k) : (int)(sum % k+k);

            count += remArr[rem];
            
			remArr[rem]+=1;;
        }
        return count;
    }
}

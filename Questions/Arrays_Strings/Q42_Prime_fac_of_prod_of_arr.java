//https://leetcode.com/contest/weekly-contest-326/problems/distinct-prime-factors-of-product-of-array/
package Arrays_Strings;
import java.util.*;

class Solution {
    private int [] primeSieve(){
        int [] prime=new int[1001];
        prime[0]=prime[1]=1;
        
        for(int i=2; i*i<=1000 ;i++){
            
            if(prime[i]==0){
                for(int j=i*i; j<=1000 ;j+=i){
                    prime[j]=1;
                }
            }
        }   
        return prime;
    }
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        
        int[]prime=primeSieve();
        
        for(int i=0;i<nums.length;i++){
            
            int num=nums[i];
            if(prime[num]==0) set.add(num);
            
            else{
                for(int j=2;j<=nums[i]/2 && num >0;j++){

                    if(prime[j]==1) continue;

                    if(prime[num]==0){
                        set.add(num);
                        break;
                    }

                    if(num % j == 0){
                        set.add(j);
                        while(num > 0 && num % j==0){
                            num=num/j;
                        }
                    }
                }
            }
        }       
        return set.size();    
    }
}
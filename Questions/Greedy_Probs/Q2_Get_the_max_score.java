//https://leetcode.com/problems/get-the-maximum-score/
package Greedy_Probs;
import java.util.*;

public class Q2_Get_the_max_score {
    
    public static int maxSum(int[] nums1, int[] nums2) {
        int i=0,j=0;
        long fin_sum=0,sum1=0,sum2=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                sum1+=nums1[i];
                i++;
            }
            else if(nums2[j]<nums1[i]){
                sum2+=nums2[j];
                j++;
            }
            else{

                fin_sum+=Math.max(sum1,sum2) + nums1[i];
                
                sum1=sum2=0;
                i++;
                j++;
            }
        }

        while(i<nums1.length){
            sum1+=nums1[i];
            i++;
        }

        while(j<nums2.length){
            sum2+=nums2[j];
            j++;
        }

        fin_sum+=Math.max(sum1,sum2);
        
        return (int)(fin_sum %1000000007);
    }
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr1=new int[n];

        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        n=sc.nextInt();
        int[] arr2=new int[n];

        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println(maxSum(arr1, arr2));
        sc.close();
    }
}

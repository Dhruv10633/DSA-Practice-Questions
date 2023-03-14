//https://leetcode.com/problems/array-partition/description/
package Arrays_Strings;
import java.util.*;

public class Q10_Array_Partition {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum=0;

        for(int i=0;i<nums.length-1;i+=2){
            // sum+=Math.min(nums[i],nums[i+1]);
            sum+=nums[i]; // same as above statement as the 1st is always the min one
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr1=new int[n];

        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println(arrayPairSum(arr1));
        sc.close();
    }
}

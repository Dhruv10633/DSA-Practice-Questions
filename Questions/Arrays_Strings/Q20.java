package Arrays_Strings;
import java.util.*;

public class Q20 {
    
    private static void max_subarr_of_sum_0(int[] arr) {
        Map<Integer,Integer> presum=new HashMap<>();
        presum.put(0, 0);

        int sum=0;
        int max_len=-1;

        for(int i=0 ; i<arr.length ; i++){
            sum+=arr[i];

            if(presum.containsKey(sum)){
                int j=presum.get(sum);
                max_len=Math.max(max_len, (i+1)-j);
            }
            else{
                presum.put(sum,i+1);
            }
        }

        System.out.println(max_len);
    }

    public static void main(String[] args) {
        
        int[] arr={9,-3,3,-1,6,-5};
        // int[] arr={6,-2,2,-8,1,7,4,-10};

        max_subarr_of_sum_0(arr);

    }
}

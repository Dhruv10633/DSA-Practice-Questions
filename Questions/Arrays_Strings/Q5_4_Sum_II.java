// https://leetcode.com/problems/4sum-ii/description/
package Arrays_Strings;
import java.util.*;

public class Q5_4_Sum_II {

    //Bruteforce
    public static int fourSumCount_brut(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    for(int l : nums4)
                        if(i + j + k + l == 0) count++;
        return count;
    }

    //Optimal
    // Now we need a+b+c+d=0 which is also (a+b)=-(c+d);
    // thus we first put in map all (a+b) values from arr1,2
    // then we check -(c+d) values from arr3,4 in the map and keep the count
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums1){
            for(int j : nums2){

                // System.out.println(i+" "+j+" "+(i+j));
                if(map.containsKey(i+j)){
                    map.put(i+j , map.get(i+j) +1);
                }
                else{
                    map.put(i+j , 1);
                }
                
            }
        }

        System.out.println();
        for(int i : nums3){
            for(int j : nums4){

                // System.out.println(i+" "+j+" "+-(i+j));
                if(map.containsKey(-(i+j))){

                    //temp is all the possible combinations
                    count+=map.get(-(i+j));       
                }
            }
        }        

        return count;
    }


}

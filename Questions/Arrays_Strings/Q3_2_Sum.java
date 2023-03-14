//https://leetcode.com/problems/two-sum/
package Arrays_Strings;
import java.util.*;

public class Q3_2_Sum {
    
    public static void n2(int[] arr,int size,int target) {
        for(int i=0;i<size;i++){

            if(arr[i]<target){
                for(int j=i+1;j<size;j++){
                    if(arr[i]+arr[j]==target){
                        System.out.println(i+" "+j);
                    }
                }
            }
            
        }
    }

    //Using Hashmap since we cannot change the index by sort
    public static void time_complex_n(int[] arr,int size,int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<size;i++){
            map.put(arr[i],i);
        }

        for(int i=0;i<size;i++){
            int req=target-arr[i];

            if(map.containsKey(req) && map.get(req)!=i){
                System.out.println(i+" "+map.get(req));

                // return new int[]{i,map.get(req)};  //for leetcode
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int target=sc.nextInt();

        int[] arr=new int[1000];
        int size=0;
        while(sc.hasNext()){
            arr[size++]=sc.nextInt();
        }

        time_complex_n(arr, size, target);
        n2(arr, size, target);
        sc.close();
    }
}

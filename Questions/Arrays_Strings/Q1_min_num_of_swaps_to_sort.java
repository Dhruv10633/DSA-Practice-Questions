package Arrays_Strings;
import java.util.*;

public class Q1_min_num_of_swaps_to_sort{

    public static int min_Swaps(int[] arr,int n) {
        int[] sort_arr=new int[n];

        //HashMap (unsorted)  (for sorted use TreeMap)
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            sort_arr[i]=arr[i];

            //key val pair to map
            map.put(arr[i],i);
        }

        Arrays.sort(sort_arr);

        int count=0;

        for(int i=0 ; i<n ; i++){
            
            //if diff in sorted and orig. arr
            if(arr[i] != sort_arr[i]){
                //reading value from the sort_arr[i] key
                int index=map.get(sort_arr[i]);

                //Swapping the elements
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;

                count++;

                //Swapping Map elements so that it reflects the changed arr positions
                map.put(arr[i], i); 
                map.put(arr[index], index);//this no need cause this change is being doen by swappign in arr acc to hash map
                                           //thus the hmap already has this
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(min_Swaps(arr,n));
        sc.close();
    }
}
package Topics.T6_Sorting;

public class Insertion_Sort {
    
    public static void main(String[] args){
        int[] arr=new int[]{1,6,4,2,5,2,3,0,-1};

        

        for(int i=1;i<arr.length;i++){
            int s=i-1,e=i;
            while(s>=0 && arr[e]<arr[s]){
                int swap=arr[e];
                arr[e]=arr[s];
                arr[s]=swap;
                e--;
                s--;
            }

        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

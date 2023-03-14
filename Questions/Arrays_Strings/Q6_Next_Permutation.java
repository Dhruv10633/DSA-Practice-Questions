package Arrays_Strings;
import java.util.*;


//1. traverse from last and find the first num that is less than the right num from last to be swapped
//2. again traverse from last and check the first num greater than the num to swapped .
//   (since the last part of array is sorted in ascending from last till the element to be swapped)
//3. swap the above 2 nums
//4. reverse the last part of arr 

public class Q6_Next_Permutation {

    public static void reverse(int[] num,int i) {
        
        int k=i ,n=num.length-1;
        while(k<n){
            int temp=num[k];
            num[k]=num[n];
            num[n]=temp;
            k++;
            n--;
        }
    }
    
    public static void nextPermutation(int[] num) {
        int n=num.length;

        //bool if permutation is possible (not possble for an entirely descending num)
        int bool=0;
        //Step 1
        for(int i=n-2;i>=0;i--){

            if(num[i]<num[i+1]){

                //if we found the 1st smallest num and thus the permutaion exists
                bool=1;

                for(int j=n-1 ; j>i ; j--){
                    
                    //if we find the 1st num> the num[i];
                    if(num[j]>num[i]){

                        //Step 3 :swap
                        int temp=num[j];
                        num[j]=num[i];
                        num[i]=temp;
                        break;
                    }
                }
                reverse(num,i+1); //reverse from  i+1 to last
                return;
            }
        }

        //if the number is in descending order eg 321 then the next permut is 123 i.e. reverse
        if(bool==0){
            reverse(num,0);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        nextPermutation(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");;
        }
        sc.close();
   
    }

}


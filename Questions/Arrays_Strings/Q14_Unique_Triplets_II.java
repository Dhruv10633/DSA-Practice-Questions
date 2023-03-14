// https://codeforces.com/problemset/problem/1692/F
package Arrays_Strings;
import java.util.*;

public class Q14_Unique_Triplets_II {

    public static void Unique_Triplets_II(int [] freq) {
        
        for(int i=0;i<10;i++){
            if(freq[i]==0){
                continue;
            }
            else{
                freq[i]--;
                //we take j=i instead of i+1 
                for(int j=i;j<10;j++){
                    if(freq[j]==0){
                        continue;
                    }
                    else{
                        freq[j]--;
                        for(int k=j;k<10;k++){
                            if(freq[k]==0){
                                continue;
                            }
                            if((i+j+k)%10==3){
                                System.out.println("YES");
                                return;
                            }
                        }
                        freq[j]++;
                    }
                }
                freq[i]++;
            }
        }
        System.out.println("NO");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t--!=0){
            int n=sc.nextInt();

            //since we need only the the last digit we can reduce any n numbers to just an freq arr just containing their last digits
            int[] freq=new int[10];

            for(int i=0;i<n;i++){
                freq[sc.nextInt()%10]++;
            }

            Unique_Triplets_II(freq);
        }
        sc.close();
    }    
}

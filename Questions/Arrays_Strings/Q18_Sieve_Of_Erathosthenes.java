package Arrays_Strings;
import java.util.*;

public class Q18_Sieve_Of_Erathosthenes {
    
    private static void Erathosthenes(int n) {
        
        boolean[] arr=new boolean[n/2 +1];
        arr[0]=arr[1]=false;

        for(int i=2;i<=n/2;i++){
            arr[i]=true;
        }

        for(int i=2;i<=n/2;i++){

            if(arr[i]){
                for(int j=i*i ;j<=n/2;j+=i){
                    arr[j]=false;
                }
            }   
        }
        
        List<Integer> prime=new ArrayList<>();

        for(int i=2;i<=n/2;i++){
            if(arr[i]){
                // System.out.println(i+" "+arr[i]);
                prime.add(i);
            }   
        }

        int len=prime.size();
        int ans=Integer.MAX_VALUE;
        for(int i=0 , j=len-1 ; i<j ; ){
            if(prime.get(i)*prime.get(i) + prime.get(j)*prime.get(j)==n){
                ans=Math.min(ans, prime.get(i) + prime.get(j));
                i++;
                j--;
            }

            else if(prime.get(i)*prime.get(i) + prime.get(j)*prime.get(j) < n){
                i++;
            }

            else{
                j--;
            }
        }
        if(ans==Integer.MAX_VALUE) ans=-1;
        System.out.println(ans);
        
    }

    public static void main(String[] args) {
        int n=7;
        Erathosthenes(n);
    }
}

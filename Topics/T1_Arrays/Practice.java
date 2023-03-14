
import java.util.*;

public class Practice{
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[][] arr=new int[n][n];
        
        for(int i=0; i<n ; i++ ){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<n ; i++ ){
            int k=i;
            for(int j=0; j<n && k>=0 ;j++,k--){
                System.out.print(arr[k][j]+" ");
            }
            System.out.println();
            
        }
        for(int j=1 ; j<n ; j++){
            int l=j;

            for(int k=n-1; l<n && k>=0 ;l++,k--){
                System.out.print(arr[k][l]+" ");
            }
            System.out.println();

        }

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         for(int k=i;k<=j;k++){
        //             System.out.print(arr[k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         for(int k=i;k<=j;k++){
        //             System.out.print(arr[k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
    }
}

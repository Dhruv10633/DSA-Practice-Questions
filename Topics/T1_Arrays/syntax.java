import java.util.*;

public class syntax{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //use sc.next() for taking space seperated input
        //use sc.nextLine() for taking line seperated input or when u need string with spaces in between

        // arr in java follow this syntax ONLY while declaring an array
        // String n=sc.next();
        String[][] arr=new String[3][3]; 

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.next();
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}
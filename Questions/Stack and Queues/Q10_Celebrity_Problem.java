import java.util.*;
public class Q10_Celebrity_Problem {
    public static void celeb(int[][] arr,int n) {
        Stack<Integer> poss=new Stack<>();
        for(int i=0 ; i<n ; i++){
            poss.push(i);
        }
        
        // this while loop tells us which are definitely not celebrities gets
        // popped out but there is no guarantee that the last left is cebrity.
        while(poss.size()>1){

            int a=poss.pop();
            int b=poss.pop();
            // cout<<a<<" "<<b<<"  b-"<<poss.size();

            // if a knows b ,but b doesn't know a ,then a is not celebrity and b can be celebrity
            if(arr[a][b]==1 && arr[b][a]==0){
                poss.push(b);
            }
            // Vice versa of above
            else if(arr[a][b]==0 && arr[b][a]==1){
                poss.push(a);
            }
            // if they both don't know each other then no celeb
            else{
                System.out.println(-1);
                return;
            }

            // cout<<"  a-"<<poss.size()<<endl;   
        }
        
        //to check if the last person left is celebrity
        for(int j=0 ; j<n ; j++){
            // checking row wise if everyone knows him except himself (cause that's always 0 for everyone)
            if(arr[j][poss.peek()]==0 && j!=poss.peek()){
                System.out.println("No Celebrity");
                return;
            }

            //checking column wise if he knows anyone
            if(arr[poss.peek()][j]==1){
                System.out.println("No Celebrity");
                return;
            }
        }
        System.out.println(poss.peek());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        celeb(arr,n);
        sc.close();
    }
}
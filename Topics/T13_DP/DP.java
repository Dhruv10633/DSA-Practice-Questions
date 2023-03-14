package Topics.T13_DP;
// package T14_DP;

/*
DP is used in 2 ways:
1. Top Down: Recursion + (memoization)
2. Bottom up: Iteration + (tabulation)

keeps track of the earlier solutions which can be used instead of calculating every other time


Where to use (Recursion):
When u have to find all the possible combinations

1D array DP : when state of only 1 thing is changing eg. amount,money,sum etc

2D array DP : when states of 2 things are changing


*/

public class DP {
    //Fibonacci TOP DOWN
    private static int  fibo(int n, int[]fib){
        if(n==0 || n==1){
            return n;
        }
        //returning the val if we have calculated before
        if(fib[n]!=0){
            return fib[n];
        }
        //if not calculated then we calculate it
        fib[n] = fibo(n-1, fib)+fibo(n-2, fib);
        return fib[n];
    }

    //Fibonacci BOTTOM UP
    private static int  fibo2(int n, int[]fib){
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }


    

    public static void main(String args[]) {
        //to use DP on n num we need size n+1
        int n=45;
        int[] fib=new int[n+1];

        //Top Down
        System.out.println(fibo(n,fib));
        //Bottoms up
        System.out.println(fibo2(n,fib));
    }
}

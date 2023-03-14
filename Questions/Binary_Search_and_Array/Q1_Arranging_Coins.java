package Binary_Search_and_Array;
// https://leetcode.com/problems/arranging-coins/

// import java.util.*;

public class Q1_Arranging_Coins{
    public static int arrangeCoins_opt(int n) {
        long l=1,h=n;
        long ans=-1;
        while(l<=h){
            //num of rows filled
            //here the test cases are very big bordering on the limit of int,
            //so even adding 1 can cause it to tip over thus use long
            
            //mid here refers to the coins in last finished row
            long mid=(l+h)/2;
            long sum=(mid*(mid+1))/2;

            if(sum == n){
                ans=mid;
                break;
            }
            else if(sum<n){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return(int) ans;
        
    }

    public static int arrangeCoins_brut(int n) {
        int row=1;
        int count=0;
        while(n>0){
            n=n-row;

            row++;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int n=5;
        arrangeCoins_opt(n);
    }
}
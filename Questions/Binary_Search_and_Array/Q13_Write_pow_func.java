//https://leetcode.com/problems/powx-n/submissions/876021565/
package Binary_Search_and_Array;

class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        if(n==0 || x==1) return ans;
        if(x==-1) {
            if(n%2==0){
                return ans;
            }
            else{
                return -ans;
            }
        }
        if(x==0) {
            return x;
        }
        
        if(Integer.compare(n,Integer.MIN_VALUE) == 0){
            return 0;
        }
        
        boolean neg;
        if(n>0){
            neg=false;
        }
        else{
            neg=true;
            n=-n;
        }

        for(int i=0;i<n;i++){
            ans*=x;
        }

        if(neg){
            return 1/ans;
        }
        else{
            return ans;
        }
    }
}

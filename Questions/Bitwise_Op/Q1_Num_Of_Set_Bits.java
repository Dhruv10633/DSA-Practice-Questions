// https://leetcode.com/problems/number-of-1-bits/
package Bitwise_Op;


class Solution {
    // you need to treat n as an unsigned value

    //Method1
    public int hammingWeight(int n) {
        int cnt=0;
        while(n>0){
            if((n&1)==1) cnt++;
            n=n>>1;
        }
        return cnt;
    }

    //Method2 - Optimal
    public int hammingWeight2(int n) {
        int cnt=0;
        //this executes as many times as number of 1
        while(n>0){
            n=n&n-1;
            cnt++;
        }
        return cnt;
    }
}
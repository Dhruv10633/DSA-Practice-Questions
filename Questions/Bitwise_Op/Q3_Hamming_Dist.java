//https://leetcode.com/problems/hamming-distance/
package Bitwise_Op;

class Solution {
    public int hammingDistance(int x, int y) {
        //this get us all the diff. bits in those num
        int num=x ^ y;
        int hmd=0;
        //counting the num of set bits (as that will be the number of unique bits)
        while(num>0){
            num &= num-1;
            hmd++;
        }
        return hmd;
    }
}

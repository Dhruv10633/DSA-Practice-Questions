// https://leetcode.com/problems/count-ways-to-build-good-strings/description/
package DP;
import java.util.*;

class Solution {
    int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return solveMem(0, low, high, zero, one, map);
    }

    
    private int solveMem(int len, int l, int h, int zero, int one, HashMap<Integer, Integer> map){
        if(len > h){
            return 0;
        }
        if(map.containsKey(len)){
            return map.get(len);
        }

        int cnt=0;
        if(len >= l && len <= h){
            cnt=1;
        }

        cnt += (solveMem(len+zero, l, h, zero, one, map) % mod);

        cnt += (solveMem(len+one, l, h, zero, one, map) % mod);

        cnt %= mod;
        map.put(len, cnt);

        return cnt;
    }
}
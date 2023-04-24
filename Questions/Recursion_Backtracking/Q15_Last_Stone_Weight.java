package Recursion_Backtracking;

class Solution {
    public int lastStoneWeight(int[] stones) {
        return solveMem(stones, stones.length);
    }


    private int solveMem(int[] stones, int count){
        if(count==0) return 0;
        if(count==1){
            for(int x:stones){
                if(x!=-1) return x;
            }
        }
        
        int fh=0, sh=-1;

        for(int i=0;i<stones.length;i++){
            if(stones[i]>stones[fh]){
                sh=fh;
                fh=i;
            }
            else if(fh!=i){
                if(sh==-1 || stones[i]>stones[sh]) sh=i;
            }
        }

        int diff=stones[fh]-stones[sh];

        int ans=0;

        if(diff==0){
            stones[fh]=stones[sh]=-1;
            ans = solveMem(stones, count-2);
        }
        else{
            stones[fh]=diff;
            stones[sh]=-1;
            ans = solveMem(stones, count-1);
        }

        return ans;
    }
}

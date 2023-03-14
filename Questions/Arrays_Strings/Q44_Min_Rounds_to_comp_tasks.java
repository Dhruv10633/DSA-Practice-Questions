//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hmap=new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            hmap.put(tasks[i],hmap.getOrDefault(tasks[i],0)+1);
        }

        int time=0;
        for(int t:hmap.values()){
            if(t==1) return -1;

            time+=t/3;
            
            //t not divisible by 3 then we add to tthe timer

            //eg. 31 / 3 = 10
            //also 31 = 3*9 +2*2 =11

            //eg. 25 / 3= 8
            //also 25 = 3*7 +2*2 =9
            if(t%3 !=0) time++;
            
        }
        return time;
    }
}

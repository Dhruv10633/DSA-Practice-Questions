//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        //a[0]-b[0] doesn't work for integer Max and min cases
        Arrays.sort(points,(a,b)->(Integer.compare(a[0],b[0])));

        int count=0;
        //storing the xend in sec for 0 th index
        int sec=points[0][1];

        for(int i=1;i<points.length;i++){
            //if the 1st value at ith index is less than the sec one this means that,
            //with one arrow we can burst the earlier balloon as well as this one and we store the min of the 2nd values in sec
            //eg [1,6] [2,3] to burst both ballons the max val of arrow can be 3
            if(points[i][0]<=sec){
                sec=Math.min(sec,points[i][1]);
            }

            //else we increase the count and replace the sec
            else{
                count++;
                sec=points[i][1];
            }

        }
        //count+1 for exact last cases
        return count+1;
    }
}

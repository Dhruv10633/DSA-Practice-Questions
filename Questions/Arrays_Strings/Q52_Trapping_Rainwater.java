//https://leetcode.com/problems/trapping-rain-water/
package Arrays_Strings;

class Solution {
    public int trap(int[] height) {
        //finding the prev max
        int pm[]=new int[height.length];
        pm[0]=height[0];

        for(int i=1;i<pm.length;i++){
            pm[i] = Math.max(pm[i-1],height[i]);
        }

        //finding the next max
        int nm[]=new int[height.length];
        nm[height.length-1]=height[height.length-1];

        for(int i=height.length-2 ; i>=0 ; i--){
            nm[i] = Math.max(nm[i+1],height[i]);
        }

        //Finding the total vol of water respective to each bar;
        int water=0;

        for(int i=0 ; i<height.length ; i++){
            water += Math.min(pm[i],nm[i]) - height[i];
        }

        return water;
    }
}

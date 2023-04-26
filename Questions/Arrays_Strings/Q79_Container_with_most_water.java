// https://leetcode.com/problems/container-with-most-water/description/
package Arrays_Strings;

class Solution {
    public int maxArea(int[] height) {
        int s=0, e=height.length-1, area=0;

        while(s<e){
            int b = e-s;
            int h = Math.min(height[s], height[e]);

            area = Math.max(area, b*h);

            if(height[s]<=height[e]){
                s++;
            }
            else{
                e--;
            }
        }

        return area;
    }
}

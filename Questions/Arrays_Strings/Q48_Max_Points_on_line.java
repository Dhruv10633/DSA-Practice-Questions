//https://leetcode.com/problems/max-points-on-a-line/description/
package Arrays_Strings;

class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        if (len<=2)
        {
            return len;
        }
        int max=0;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                int x1=points[i][0],y1=points[i][1],x2=points[j][0],y2=points[j][1];
                int count=2;
                for(int k=j+1;k<len;k++)
                {
                    int x3=points[k][0],y3=points[k][1];
                    if ((x2-x1)*(y3-y1)==(x3-x1)*(y2-y1))
                    {
                        count ++;
                    }
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }
}

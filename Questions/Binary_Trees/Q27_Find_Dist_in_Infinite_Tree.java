// https://practice.geeksforgeeks.org/problems/find-the-distance-between-two-nodes4402/1?page=1&company[]=PlaySimple&sortBy=submissions
package Binary_Trees;

class Solution{
    static int distance(int x,int y){
        
        //P=(C-1)/2;  to find out parent if we know child index  // when index starts from 0 then P = C/2  
        int distance=0;
        while(x!=y){
            if(x > y) x /= 2;
            else y /= 2;
            distance++;
        }
        
        return distance;
    }
}

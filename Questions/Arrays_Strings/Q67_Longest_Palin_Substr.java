// https://leetcode.com/problems/longest-palindromic-substring/description/
package Arrays_Strings;

class Solution {
    //Axis-Orbit Algo O(N^2)
    //Mancher's Algo O(N)
    
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return s;

        int maxSize = Integer.MIN_VALUE;
        String ans = s.charAt(0) + "";

        
        for(int i=0 ; i<s.length() ; i++){
            //odd len substr (we use i as axis)
            int l=i-1, r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            r--;
            l++;
            int size = r-l +1;
            if(maxSize < size){
                maxSize=size;
                ans = s.substring(l,r+1);
            }

            //even len substr (we use i,i+1 as axes)
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            r--;
            l++;
            size = r-l +1;
            if(maxSize < size){
                maxSize=size;
                ans = s.substring(l,r+1);
            }
        }

        
        

        return ans;
    }
}

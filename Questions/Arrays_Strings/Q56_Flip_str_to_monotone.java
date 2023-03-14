//https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
package Arrays_Strings;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int c1=0, toBeFlipped=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                //we can ignore the 0s till we dont find any 1(i.e the string is monotonic till then)
                if(c1==0){
                    continue;
                }
                else{
                    toBeFlipped++;
                }
            }    
            else{
                c1++;
            } 
            //to keep a check on the min number of flips at each index
            toBeFlipped = Math.min(toBeFlipped,c1);   
        }
        return toBeFlipped;
    }
}

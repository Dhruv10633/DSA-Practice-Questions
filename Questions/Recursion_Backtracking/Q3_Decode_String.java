//https://leetcode.com/problems/decode-string/
package Recursion_Backtracking;
import java.util.*;

class Solution {




    //////Recursive
    private int i=0;

    public String decodeString(String s) {
        
        StringBuilder res= new StringBuilder();

        //we havent solved our prob till we reach this
        while(i<s.length() && s.charAt(i)!=']'){
            if(!Character.isDigit(s.charAt(i))){
                res.append(s.charAt(i));
                i++;
            }
            else{
                int k=0;
                while(Character.isDigit(s.charAt(i))){
                    k=k*10 + s.charAt(i)-'0';
                    i++;
                }
                //For '['
                i++;
                String dstr=decodeString(s);

                while(k-->0){
                    res.append(dstr); 
                }
                i++;
            }
        }
        return new String(res);
    }
}

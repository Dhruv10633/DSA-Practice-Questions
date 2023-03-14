//https://leetcode.com/problems/longest-nice-substring/
package Arrays_Strings;
import java.util.*;

class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()==0){
            return s;
        }

        HashSet<Character> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }

        
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);

            //if the char has both upper and lower
            if(set.contains(Character.toLowerCase(temp)) && set.contains(Character.toUpperCase(temp))) continue;

            //if the char has no upper or lower
            else{
                String s1=longestNiceSubstring(s.substring(0,i));
                String s2=longestNiceSubstring(s.substring(i+1));

                if(s1.length()>=s2.length()) return s1;
                else return s2;
            }
        }
        return s;
    }
}
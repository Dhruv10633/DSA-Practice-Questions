// https://leetcode.com/problems/longest-substring-without-repeating-characters/
package Arrays_Strings;
import java.util.*;

public class Q26_Longest_substr_with_unique_char {
    
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();

        int len=0; int start=0;
        for(int i=0;i<s.length();i++){
            //if we find a repeating char
            if(set.contains(s.charAt(i))){
                //we start removing elements from the start till we have removed the repeating char 
                //i.e in "abcdca" , at 'c' at index 4 we delete till the 1st occurence of 'c' 
                while(start<i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(s.charAt(i));
            len=Math.max(len,set.size());
        }
        return len;
    }
}

//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

package Arrays_Strings;
import java.util.*;

public class Q24_Substr_OF_size_3_unique_char {
    private int counter=0;

    private int shortener(String s,Map<Character,Integer> map,int start,int i){
        while(map.size()==3){
            
            //i.e. map has 3 unique elements 
            //a substring of length 3
            if(map.size()==3 && start+2==i) counter++;

            char temp=s.charAt(start);

            //we remove the element at start pos as we shorten the window 
            map.put(temp,map.get(temp)-1);
            if(map.get(temp)<=0) map.remove(temp);

            start++;
        }

        return start;
    }

    public int countGoodSubstrings(String s) {
        
        int start=0;
        
        Map<Character,Integer> map=new HashMap<>();


        for(int end=0 ; end<s.length() ; end++){
            char temp=s.charAt(end);
            map.put(temp, map.getOrDefault(temp,0)+1);

            //if we find 3 unique elements in our sliding window from start to end
            if(map.size()>=3){
                start=shortener(s,map,start,end);
            }
        }

        return counter;
        
    }
}

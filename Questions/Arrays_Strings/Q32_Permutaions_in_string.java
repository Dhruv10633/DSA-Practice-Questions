//https://leetcode.com/problems/permutation-in-string/
package Arrays_Strings;
import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        //freq map of s1
        HashMap<Character,Integer> mp1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char temp=s1.charAt(i);
            mp1.put( temp, mp1.getOrDefault(temp,0)+1);
        }

        //window size
        int windS=s1.length();
        int s=0,e=0;

        //1st window of s1 length / window size 
        HashMap<Character,Integer> mp2=new HashMap<>();
        for(; e<windS ;e++){
            char temp=s2.charAt(e);
            mp2.put( temp, mp2.getOrDefault(temp,0)+1);
        }
        if(mp1.equals(mp2)) return true; //check

        for(; e<s2.length() ;e++){
            //adding e ele in map
            char temp=s2.charAt(e);
            mp2.put( temp, mp2.getOrDefault(temp,0)+1);

            //removing ele from s so as to balance the size of window
            temp=s2.charAt(s);
            if(mp2.get(temp)==1){
                mp2.remove(temp);
            }
            else{
                mp2.put(temp, mp2.get(temp)-1);
            }
            s++;

            //check
            if(mp1.equals(mp2)) return true;
        }
        
        return false;

    }
}
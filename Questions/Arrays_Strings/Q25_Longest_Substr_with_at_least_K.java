// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
package Arrays_Strings;
import java.util.*;

class Solution {
    //Divide and Conquer approach
    public int longestSubstring(String s, int k) {
        if(s.length()==0){
            return 0;
        }

        HashMap<Character,Integer> strMap =new HashMap<>();

        for(int i=0;i<s.length();i++){
            strMap.put( s.charAt(i) , strMap.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);

            if(strMap.get(temp)>=k){
                continue;
            }
            else{
                int l1=longestSubstring(s.substring(0,i),k);
                int l2=longestSubstring(s.substring(i+1),k);

                return Math.max(l1,l2);
            }
        }
        return s.length();
    }

    
    //Optimal 2 pointer Sliding window
    public int longestSubstring2(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        
        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0; 
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                }
                else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        
        return max;
    }

}
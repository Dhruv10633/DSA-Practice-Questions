//https://leetcode.com/problems/palindrome-partitioning/solutions/
package Recursion_Backtracking;
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        return palin(s, new ArrayList<String>(), new HashSet<String>());
    }

    private List<List<String>> palin(String s, List<String> li, HashSet<String> set) {
        List<List<String>> ans = new ArrayList<>();
        
        if(s.length()==0){
            ans.add(new ArrayList<>(li));
            return ans;
        }

        //check for all length palin substr from the "s" at the given point of time
        for(int i=1 ; i<=s.length() ; i++){
            String str = s.substring(0,i);

            if(set.contains(str) || isPalin(str)){
                li.add(str);
                set.add(str);
                List<List<String>> temp = palin(s.substring(i), li, set);
                // System.out.println(temp);
                for(List<String> t:temp){
                    ans.add(t);
                }
                li.remove(li.size()-1);
            }
        }

        return ans;
    }

    private boolean isPalin(String s){
        if(s.length()==0) return false;

        for(int i=0, j=s.length()-1 ; i<j ; i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

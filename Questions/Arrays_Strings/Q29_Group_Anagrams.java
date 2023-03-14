//https://leetcode.com/problems/group-anagrams/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();

        //Do not use char array instead of internal HashMap as refernece of each char array is different
        HashMap<HashMap<Character,Integer> ,List<String>> map=new HashMap<>();

        
        for(int i=0 ;i<strs.length;i++){
            
            //Creating HashMap for each string in strs
            HashMap<Character,Integer> smp1=new HashMap<>();
            for(int j=0 ;j < strs[i].length(); j++){
                char temp=strs[i].charAt(j);
                smp1.put( temp, smp1.getOrDefault(temp,0)+1);
            }
            
            
            //Checking if same map of this string (anagram) already there

            //if there we just add the string to the list
            if(map.containsKey(smp1)){
                map.get(smp1).add(strs[i]);
            }

            //if not then we create a new List and then add the string to it, and then allot it to the Map
            else{
                List<String> anag=new ArrayList<>();
                anag.add(strs[i]);
                map.put( smp1 , anag );
            }
            
            
        }

        //iteratng once over the main map and adding all the lists assigned to the internal maps to the ans
        for(HashMap<Character,Integer> mp : map.keySet()){
            ans.add(map.get(mp));
        }

        return ans;
    }
}

//// https://leetcode.com/problems/naming-a-company/description/
package Arrays_Strings;
import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        //Hash array contains sets of all the suffixes for that alphabet
        HashSet<String>[] arr=new HashSet[26];

        for(int i=0;i<ideas.length;i++){
            int pos=ideas[i].charAt(0) - 'a';

            if(arr[pos] != null) {
                arr[pos].add(ideas[i].substring(1));
            }
            else {
                HashSet<String> set=new HashSet<>();
                set.add(ideas[i].substring(1));
                arr[pos]=set;
            }
        }

        long ans=0;

        for(int i=0 ; i < 26-1 ; i++){

            if(arr[i]==null) continue;

            for(int j=i+1 ; j<26 ; j++){
                
                if(arr[j]==null) continue;

                //checking for all unique suffixes in both sets of the "i" and "j"
                //as in case of same suffixes on interchanging the 1st alphabet of the 2 words
                //we get words which are there in the "ideals" array
                int c1=0, c2=0;
                for(String k : arr[i]){
                    if(!arr[j].contains(k)) c1++;
                }

                for(String k : arr[j]){
                    if(!arr[i].contains(k)) c2++;
                }

                ans += (c1*c2)*2;
            }
        }

        return ans;
    }
}


//https://leetcode.com/problems/determine-if-two-strings-are-close/
package Arrays_Strings;
import java.util.*;

public class Q12_Determine_if_Two_Strings_Are_Close {
    
    public static boolean closeStrings(String word1, String word2) {
        //strategy: Greedy
        //different lengths are automatically false
        if (word1.length() != word2.length()) {
            return false;
        }
        //Operation 1 allows us to move all characters freely
        //Opereration 2 allows us to reassign the characters
        //keep a frequency char of both word1 and word2
        int[] one = new int[26];
        int[] two = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            one[word1.charAt(i) - 'a']++;
            two[word2.charAt(i) - 'a']++;
        }
        //make sure the characters are the same in order to reassign letters
        for (int i = 0; i < 26; i++) {
            if ((one[i] > 0 && two[i] == 0) || (one[i] == 0 && two[i] > 0)) {
                return false;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //see if there are frequencies that match up in both words
        for (int i = 0; i < 26; i++) {
            if (one[i] != 0) {
                map.put(one[i], map.getOrDefault(one[i], 0) + 1);
            }
            if (two[i] != 0) {
                map.put(two[i], map.getOrDefault(two[i], 0) - 1);
            }
        }
        //all frequences should be 0 so that means we can reassign the frequencies
        for (int key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean closeStrings2(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;

        HashMap<Integer,Integer> freq_map=new HashMap<>();

        HashMap<Character,Integer> char_map1=new HashMap<>();
        HashMap<Character,Integer> char_map2=new HashMap<>();

        //creating char_maps for both words with their freq
        for(int i=0;i<word1.length();i++){
            char ch1=word1.charAt(i);
            char ch2=word2.charAt(i);

            char_map1.put(ch1, char_map1.getOrDefault(ch1,0)+1);

            char_map2.put(ch2, char_map2.getOrDefault(ch2,0)+1);

        }
        //we first check if the chars in both strings are same
        for(char ch:char_map1.keySet()){
            if(!char_map2.containsKey(ch)){
                return false;
            }
        }


        //Now we check if the freq of those chars are equal 
        //by creating a freq_map which keeps a track if the frequencies of chars in both words
        //which are in the val part of the char maps are equal for both words
        // eg. abbc (1,2,1)  ,  baac(1,2,1)  
        for(int i:char_map1.values()){
            freq_map.put(i, freq_map.getOrDefault(i,0)+1);
        }
        
        for(int i:char_map2.values()){
            freq_map.put(i, freq_map.getOrDefault(i,0)-1);
        }

        
        //checking if the freq of both words are equal (so that we can)
        for(int i:freq_map.values()){  
            if(i!=0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(closeStrings2("uau","ssx"));
    }
}

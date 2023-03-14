//https://leetcode.com/problems/largest-merge-of-two-strings/
package Greedy_Probs;
import java.util.*;

public class Q1_Largest_Merge_of_2_strings {
    
    public static String largestMerge_recurs(String word1, String word2, String ans) {
        //Stopping cond : if either word empty
        if(word1.isEmpty() || word2.isEmpty()){
            return ans+word1+word2;
        }

        if(word1.charAt(0) > word2.charAt(0)){
            return largestMerge_recurs(word1.substring(1) , word2 , ans+word1.charAt(0));
        }

        else if(word1.charAt(0) < word2.charAt(0)){
            return largestMerge_recurs(word1 , word2.substring(1) , ans+word2.charAt(0));
        }

        // if charAt 0 for both words are same
        else{
            String s1=largestMerge_recurs(word1.substring(1),word2,ans+word1.charAt(0));
            String s2=largestMerge_recurs(word1,word2.substring(1),ans+word2.charAt(0));

            if(s1.compareTo(s2) > 0){
                return s1;
            }
            
            else return s2;
            
        }

    }


    //Optimised
    public static String largestMerge_recurs_opt(String word1, String word2, String ans) {
        //Stopping cond : if either word empty
        if(word1.isEmpty() || word2.isEmpty()){
            return ans+word1+word2;
        }

        if(word1.charAt(0) > word2.charAt(0)){
            return largestMerge_recurs_opt(word1.substring(1) , word2 , ans+word1.charAt(0));
        }

        else if(word1.charAt(0) < word2.charAt(0)){
            return largestMerge_recurs_opt(word1 , word2.substring(1) , ans+word2.charAt(0));
        }

        // if charAt 0 for both words are same or eq
        else{
            
            //here we lexographically compares the remaining the word1,2 substrings
            //and then do the operation based on that
            if(word1.compareTo(word2) > 0){
               return largestMerge_recurs_opt(word1.substring(1) , word2 , ans+word1.charAt(0));
            }
            
            else  return largestMerge_recurs_opt(word1 , word2.substring(1) , ans+word2.charAt(0));
            
        }

    }

    
    public static String largestMerge_iter(String word1, String word2){
        //StringBuilder is mutable whereast String is not
        //We use StringBuilder because
        //Since String is immutable in Java, whenever we do String manipulation like concatenation, substring, etc. 
        //it generates a new String and discards the older String for garbage collection. 
        //These are heavy operations and generate a lot of garbage in heap
        
        StringBuilder ans=new StringBuilder();
        int i=0,j=0;

        while(i<word1.length() && j<word2.length()){
            
            if(word1.charAt(i) > word2.charAt(j)){
                ans.append(word1.charAt(i));
                i++;
            }

            else if(word1.charAt(i) < word2.charAt(j)){
                ans.append(word2.charAt(j));
                j++;
            }

            else{
                //here we lexographically compares the remaining the word1,2 substrings 
                //and then do the operation based on that

                if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                    ans.append(word1.charAt(i));
                    i++;
                }
                else{
                    ans.append(word2.charAt(j));
                    j++;
                }
            }
        }

        if(i<word1.length()){
            ans.append(word1.substring(i));
        }
        if(j<word2.length()){
            ans.append(word2.substring(j));
        }

        return ans.toString();

    }
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String word1=sc.next();
        String word2=sc.next();

        System.out.println(largestMerge_recurs_opt(word1, word2,""));
        sc.close();
    }   
}

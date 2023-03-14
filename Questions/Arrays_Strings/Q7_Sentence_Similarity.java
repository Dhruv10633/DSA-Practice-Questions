//https://leetcode.com/problems/sentence-similarity-iii/
package Arrays_Strings;
import java.util.*;

public class Q7_Sentence_Similarity {
    
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1=sentence1.split(" ");
        String[] s2=sentence2.split(" ");
        
        int i=0,j=0;

        while(i<s1.length && j<s2.length){
            if(!s1[i].equals(s2[j])){
                i--;
                j--;
                break;
            }
            i++;
            j++;
        }
        if (i == s1.length || j == s2.length) return true;


        int m=s1.length-1,n=s2.length-1;

        while(m>=0 && n>=0){
            if(!s1[m].equals(s2[n])){
                m++;
                n++;
                break;
            }
            m--;
            n--;
        }
        
        // m==i || n==j  returns true when the sen1,sen2 is a part of other sentence
        // i+1==m || j+1==n returns true when sen1,sen2 consists of 1st and last words of the other sentence 
        return m==i || n==j || i+1==m || j+1==n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s1=sc.nextLine();
        String s2=sc.nextLine();

        System.out.println(areSentencesSimilar(s1,s2));
        sc.close();
    }
}

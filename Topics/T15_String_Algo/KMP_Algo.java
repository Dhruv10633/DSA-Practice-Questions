package Topics.T15_String_Algo;


//Prefix - any substring with left most char
//Suffix - any substring with right most char
public class KMP_Algo {
    public int strStr(String haystack, String needle) {
        int j=0, i=1;

        //LPS of Needle String
        int[] lps = new int[needle.length()+1];
        while(i < needle.length()){
            //if equal then we take the length of string till j (j+1 as index is 1 less)
            //as the prev strings from 0 to j == 
            if(needle.charAt(i)==needle.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }

            //if not found
            else{
                //if j==0 then no string length poss
                if(j==0) 
                    i++;          
                else 
                    j = lps[j-1];
            }
        }
        
        i=0;
        j=0;
        while(i < haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;

                if(j==needle.length()){
                    // if we want 1st occurence
                    return i-j;  
                    
                    //if we want all occurences then (comment above return cond)
                    // j = lps[j-1];
                    // count++;
                }
            }
            else{
                if(j==0) 
                    i++;
                else j = 
                    lps[j-1];
            }

        }
        
        return -1;
    }
}

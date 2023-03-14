//https://leetcode.com/problems/longest-repeating-character-replacement/description/
package Arrays_Strings;

class Solution {
    public int characterReplacement(String str, int k) {
        int[] arr=new int[26];
        int s=0, e=0;
        int maxFreq=0;
        int ans=0;

        while(e<str.length()){
            arr[str.charAt(e)-'A']++;
            maxFreq = Math.max(maxFreq, arr[str.charAt(e)-'A']);
            //when the number of ele. other than the maxFreq one are more than what can be replaced (k)
            //then we start to shorten the window
            while((e+1)-s-maxFreq > k){
                arr[str.charAt(s)-'A']--;
                s++;
            }

            ans=Math.max(ans, (e+1)-s);
            e++;
        }

        return ans;
    }    


    //Bruteforce (TLE)

    // public int characterReplacement(String s, int k) {
    //     int ans=0;

    //     for(int i=0;i<s.length();i++){
    //         char t1=s.charAt(i);

    //         int count=1, diff=k;
    //         for(int j=i+1;j<s.length() ;j++){
    //             char t2=s.charAt(j);
    //             if(t2!=t1){
    //                 diff--;
    //                 if(diff<0){
    //                     break;
    //                 }
    //             }
    //             count++;    
    //         }

    //         ans=Math.max(ans,count);

    //         count=0;
    //         diff=k;
    //         for(int j=0;j<s.length() ;j++){
    //             char t2=s.charAt(j);
    //             if(t2!=t1){
    //                 diff--;
    //                 if(diff<0){
    //                     break;
    //                 }
    //             }
    //             count++;    
    //         }
    //         ans=Math.max(ans,count);
    //     }
    //     return ans;
    // }
}
